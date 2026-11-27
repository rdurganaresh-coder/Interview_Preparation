package com.leetcode.arrays_hashing_greedy;

class Solution2737 {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        final int inf = 1 << 29;
        int[][] g = new int[n][n];
        for (var e : g) {
            Arrays.fill(e, inf);
        }
        for (var e : edges) {
            int u = e.get(0), v = e.get(1), w = e.get(2);
            g[u][v] = Math.min(g[u][v], w);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[s] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        int ans = inf;
        for (int i : marked) {
            ans = Math.min(ans, dist[i]);
        }
        return ans >= inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2737 _tcSol = new Solution2737();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1,1],[1,2,3],[2,3,2],[0,3,4]], s = 0, marked = [2,3]");
        try {
            int n = 4;
            List<List<Integer>> edges = _tcL(_tcL(0, 1, 1), _tcL(1, 2, 3), _tcL(2, 3, 2), _tcL(0, 3, 4));
            int s = 0;
            int[] marked = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDistance(n, edges, s, marked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1,2],[0,2,4],[1,3,1],[2,3,3],[3,4,2]], s = 1, marked = [0,4]");
        try {
            int n = 5;
            List<List<Integer>> edges = _tcL(_tcL(0, 1, 2), _tcL(0, 2, 4), _tcL(1, 3, 1), _tcL(2, 3, 3), _tcL(3, 4, 2));
            int s = 1;
            int[] marked = new int[]{0, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDistance(n, edges, s, marked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1,1],[1,2,3],[2,3,2]], s = 3, marked = [0,1]");
        try {
            int n = 4;
            List<List<Integer>> edges = _tcL(_tcL(0, 1, 1), _tcL(1, 2, 3), _tcL(2, 3, 2));
            int s = 3;
            int[] marked = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDistance(n, edges, s, marked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}