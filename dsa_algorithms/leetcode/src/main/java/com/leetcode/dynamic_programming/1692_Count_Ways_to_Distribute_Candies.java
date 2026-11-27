package com.leetcode.dynamic_programming;

class Solution1692 {
    public int waysToDistribute(int n, int k) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                f[i][j] = (int) ((long) f[i - 1][j] * j % mod + f[i - 1][j - 1]) % mod;
            }
        }
        return f[n][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1692 _tcSol = new Solution1692();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 2");
        try {
            int n = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToDistribute(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, k = 2");
        try {
            int n = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToDistribute(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 20, k = 5");
        try {
            int n = 20;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToDistribute(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "206085257");
        System.out.println();
    }
}