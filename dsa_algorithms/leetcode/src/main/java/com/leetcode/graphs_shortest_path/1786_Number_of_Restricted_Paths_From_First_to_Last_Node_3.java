package com.leetcode.graphs_shortest_path;

class Solution1786_3 {
    private static final int INF = Integer.MAX_VALUE;
    private static final int MOD = (int) 1e9 + 7;

    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {0, n});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[n] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[1];
            for (int[] ne : g[u]) {
                int v = ne[0], w = ne[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new int[] {dist[v], v});
                }
            }
        }
        int[] f = new int[n + 1];
        f[n] = 1;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = i + 1;
        }
        Arrays.sort(arr, (i, j) -> dist[i] - dist[j]);
        for (int i : arr) {
            for (int[] ne : g[i]) {
                int j = ne[0];
                if (dist[i] > dist[j]) {
                    f[i] = (f[i] + f[j]) % MOD;
                }
            }
        }
        return f[1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1786_3 _tcSol = new Solution1786_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{1, 2, 3}, new int[]{1, 3, 3}, new int[]{2, 3, 1}, new int[]{1, 4, 2}, new int[]{5, 2, 2}, new int[]{3, 5, 1}, new int[]{5, 4, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countRestrictedPaths(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{1, 3, 1}, new int[]{4, 1, 2}, new int[]{7, 3, 4}, new int[]{2, 5, 3}, new int[]{5, 6, 1}, new int[]{6, 7, 2}, new int[]{7, 5, 3}, new int[]{2, 6, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countRestrictedPaths(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
