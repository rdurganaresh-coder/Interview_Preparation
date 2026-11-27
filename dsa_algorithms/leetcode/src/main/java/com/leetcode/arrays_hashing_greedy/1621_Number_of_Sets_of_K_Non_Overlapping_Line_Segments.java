package com.leetcode.arrays_hashing_greedy;

class Solution1621 {
    public int numberOfSets(int n, int k) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][k + 1];
        int[][] g = new int[n + 1][k + 1];
        f[1][0] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % mod;
                g[i][j] = g[i - 1][j];
                if (j > 0) {
                    g[i][j] = (g[i][j] + f[i - 1][j - 1]) % mod;
                    g[i][j] = (g[i][j] + g[i - 1][j - 1]) % mod;
                }
            }
        }
        return (f[n][k] + g[n][k]) % mod;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1621 _tcSol = new Solution1621();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, k = 2");
        try {
            int n = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSets(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, k = 1");
        try {
            int n = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSets(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 30, k = 7");
        try {
            int n = 30;
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSets(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "796297179");
        System.out.println();
    }
}
