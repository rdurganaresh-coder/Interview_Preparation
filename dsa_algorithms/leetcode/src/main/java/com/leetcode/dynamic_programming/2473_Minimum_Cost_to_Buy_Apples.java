package com.leetcode.dynamic_programming;

class Solution2473 {
    private int k;
    private int[] cost;
    private int[] dist;
    private List<int[]>[] g;
    private static final int INF = 0x3f3f3f3f;

    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        cost = appleCost;
        g = new List[n];
        dist = new int[n];
        this.k = k;
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (var e : roads) {
            int a = e[0] - 1, b = e[1] - 1, c = e[2];
            g[a].add(new int[] {b, c});
            g[b].add(new int[] {a, c});
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = dijkstra(i);
        }
        return ans;
    }

    private long dijkstra(int u) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, u});
        Arrays.fill(dist, INF);
        dist[u] = 0;
        long ans = Long.MAX_VALUE;
        while (!q.isEmpty()) {
            var p = q.poll();
            int d = p[0];
            u = p[1];
            ans = Math.min(ans, cost[u] + (long) (k + 1) * d);
            for (var ne : g[u]) {
                int v = ne[0], w = ne[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new int[] {dist[v], v});
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2473 _tcSol = new Solution2473();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, roads = [[1,2,4],[2,3,2],[2,4,5],[3,4,1],[1,3,4]], appleCost = [56,42,102,301], k = 2");
        try {
            int n = 4;
            int[][] roads = new int[][]{new int[]{1, 2, 4}, new int[]{2, 3, 2}, new int[]{2, 4, 5}, new int[]{3, 4, 1}, new int[]{1, 3, 4}};
            int[] appleCost = new int[]{56, 42, 102, 301};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(n, roads, appleCost, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[54,42,48,51]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, roads = [[1,2,5],[2,3,1],[3,1,2]], appleCost = [2,3,1], k = 3");
        try {
            int n = 3;
            int[][] roads = new int[][]{new int[]{1, 2, 5}, new int[]{2, 3, 1}, new int[]{3, 1, 2}};
            int[] appleCost = new int[]{2, 3, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(n, roads, appleCost, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,1]");
        System.out.println();
    }
}