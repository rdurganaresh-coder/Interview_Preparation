package com.leetcode.dynamic_programming;

class Solution1976 {
    public int countPaths(int n, int[][] roads) {
        final long inf = Long.MAX_VALUE / 2;
        final int mod = (int) 1e9 + 7;
        long[][] g = new long[n][n];
        for (var e : g) {
            Arrays.fill(e, inf);
        }
        for (var r : roads) {
            int u = r[0], v = r[1], t = r[2];
            g[u][v] = t;
            g[v][u] = t;
        }
        g[0][0] = 0;
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        dist[0] = 0;
        long[] f = new long[n];
        f[0] = 1;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!vis[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; ++j) {
                if (j == t) {
                    continue;
                }
                long ne = dist[t] + g[t][j];
                if (dist[j] > ne) {
                    dist[j] = ne;
                    f[j] = f[t];
                } else if (dist[j] == ne) {
                    f[j] = (f[j] + f[t]) % mod;
                }
            }
        }
        return (int) f[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1976 _tcSol = new Solution1976();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]");
        try {
            int n = 7;
            int[][] roads = new int[][]{new int[]{0, 6, 7}, new int[]{0, 1, 2}, new int[]{1, 2, 3}, new int[]{1, 3, 3}, new int[]{6, 3, 3}, new int[]{3, 5, 1}, new int[]{6, 5, 1}, new int[]{2, 5, 1}, new int[]{0, 4, 5}, new int[]{4, 6, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPaths(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, roads = [[1,0,10]]");
        try {
            int n = 2;
            int[][] roads = new int[][]{new int[]{1, 0, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPaths(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}