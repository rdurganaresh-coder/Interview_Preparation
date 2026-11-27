package com.leetcode.graphs_shortest_path;

class Solution2714 {
    public int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, s, 0});
        int[][] dist = new int[n][k + 1];
        final int inf = 1 << 30;
        for (int[] e : dist) {
            Arrays.fill(e, inf);
        }
        dist[s][0] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int dis = p[0], u = p[1], t = p[2];
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (t + 1 <= k && dist[v][t + 1] > dis) {
                    dist[v][t + 1] = dis;
                    pq.offer(new int[] {dis, v, t + 1});
                }
                if (dist[v][t] > dis + w) {
                    dist[v][t] = dis + w;
                    pq.offer(new int[] {dis + w, v, t});
                }
            }
        }
        int ans = inf;
        for (int i = 0; i <= k; ++i) {
            ans = Math.min(ans, dist[d][i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2714 _tcSol = new Solution2714();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1,4],[0,2,2],[2,3,6]], s = 1, d = 3, k = 2");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1, 4}, new int[]{0, 2, 2}, new int[]{2, 3, 6}};
            int s = 1;
            int d = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathWithHops(n, edges, s, d, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[3,1,9],[3,2,4],[4,0,9],[0,5,6],[3,6,2],[6,0,4],[1,2,4]], s = 4, d = 1, k = 2");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{3, 1, 9}, new int[]{3, 2, 4}, new int[]{4, 0, 9}, new int[]{0, 5, 6}, new int[]{3, 6, 2}, new int[]{6, 0, 4}, new int[]{1, 2, 4}};
            int s = 4;
            int d = 1;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathWithHops(n, edges, s, d, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, edges = [[0,4,2],[0,1,3],[0,2,1],[2,1,4],[1,3,4],[3,4,7]], s = 2, d = 3, k = 1");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 4, 2}, new int[]{0, 1, 3}, new int[]{0, 2, 1}, new int[]{2, 1, 4}, new int[]{1, 3, 4}, new int[]{3, 4, 7}};
            int s = 2;
            int d = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathWithHops(n, edges, s, d, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}