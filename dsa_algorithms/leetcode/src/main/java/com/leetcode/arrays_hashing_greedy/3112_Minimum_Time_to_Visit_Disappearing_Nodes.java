package com.leetcode.arrays_hashing_greedy;

class Solution3112 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, 1 << 30);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            var e = pq.poll();
            int du = e[0], u = e[1];
            if (du > dist[u]) {
                continue;
            }
            for (var nxt : g[u]) {
                int v = nxt[0], w = nxt[1];
                if (dist[v] > dist[u] + w && dist[u] + w < disappear[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = dist[i] < disappear[i] ? dist[i] : -1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3112 _tcSol = new Solution3112();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1, 2}, new int[]{1, 2, 1}, new int[]{0, 2, 4}};
            int[] disappear = new int[]{1, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(n, edges, disappear)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,3,5]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1, 2}, new int[]{1, 2, 1}, new int[]{0, 2, 4}};
            int[] disappear = new int[]{1, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(n, edges, disappear)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, edges = [[0,1,1]], disappear = [1,1]");
        try {
            int n = 2;
            int[][] edges = new int[][]{new int[]{0, 1, 1}};
            int[] disappear = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(n, edges, disappear)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1]");
        System.out.println();
    }
}