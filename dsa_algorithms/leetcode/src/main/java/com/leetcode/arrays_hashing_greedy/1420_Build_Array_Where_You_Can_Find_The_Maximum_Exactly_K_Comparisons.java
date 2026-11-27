package com.leetcode.arrays_hashing_greedy;

class Solution1420 {
    private static final int MOD = (int) 1e9 + 7;

    public int numOfArrays(int n, int m, int k) {
        if (k == 0) {
            return 0;
        }
        long[][][] dp = new long[n + 1][k + 1][m + 1];
        for (int i = 1; i <= m; ++i) {
            dp[1][1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int c = 1; c <= Math.min(i, k); ++c) {
                for (int j = 1; j <= m; ++j) {
                    dp[i][c][j] = (dp[i - 1][c][j] * j) % MOD;
                    for (int j0 = 1; j0 < j; ++j0) {
                        dp[i][c][j] = (dp[i][c][j] + dp[i - 1][c - 1][j0]) % MOD;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= m; ++i) {
            ans = (ans + dp[n][k][i]) % MOD;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1420 _tcSol = new Solution1420();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, m = 3, k = 1");
        try {
            int n = 2;
            int m = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, m = 2, k = 3");
        try {
            int n = 5;
            int m = 2;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 9, m = 1, k = 1");
        try {
            int n = 9;
            int m = 1;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}