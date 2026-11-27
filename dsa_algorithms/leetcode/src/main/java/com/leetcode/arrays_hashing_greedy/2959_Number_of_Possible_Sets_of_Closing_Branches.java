package com.leetcode.arrays_hashing_greedy;

class Solution2959 {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        for (int mask = 0; mask < 1 << n; ++mask) {
            int[][] g = new int[n][n];
            for (var e : g) {
                Arrays.fill(e, 1 << 29);
            }
            for (var e : roads) {
                int u = e[0], v = e[1], w = e[2];
                if ((mask >> u & 1) == 1 && (mask >> v & 1) == 1) {
                    g[u][v] = Math.min(g[u][v], w);
                    g[v][u] = Math.min(g[v][u], w);
                }
            }
            for (int k = 0; k < n; ++k) {
                if ((mask >> k & 1) == 1) {
                    g[k][k] = 0;
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < n; ++j) {
                            g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                        }
                    }
                }
            }
            int ok = 1;
            for (int i = 0; i < n && ok == 1; ++i) {
                for (int j = 0; j < n && ok == 1; ++j) {
                    if ((mask >> i & 1) == 1 && (mask >> j & 1) == 1) {
                        if (g[i][j] > maxDistance) {
                            ok = 0;
                        }
                    }
                }
            }
            ans += ok;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2959 _tcSol = new Solution2959();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, maxDistance = 5, roads = [[0,1,2],[1,2,10],[0,2,10]]");
        try {
            int n = 3;
            int maxDistance = 5;
            int[][] roads = new int[][]{new int[]{0, 1, 2}, new int[]{1, 2, 10}, new int[]{0, 2, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSets(n, maxDistance, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, maxDistance = 5, roads = [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]");
        try {
            int n = 3;
            int maxDistance = 5;
            int[][] roads = new int[][]{new int[]{0, 1, 20}, new int[]{0, 1, 10}, new int[]{1, 2, 2}, new int[]{0, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSets(n, maxDistance, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1, maxDistance = 10, roads = []");
        try {
            int n = 1;
            int maxDistance = 10;
            int[][] roads = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSets(n, maxDistance, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}