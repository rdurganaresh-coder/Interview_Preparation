package com.leetcode.dynamic_programming;

class Solution0518 {
    public int change(int amount, int[] coins) {
        int m = coins.length, n = amount;
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1]) {
                    f[i][j] += f[i][j - coins[i - 1]];
                }
            }
        }
        return f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0518 _tcSol = new Solution0518();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "amount = 5, coins = [1,2,5]");
        try {
            int amount = 5;
            int[] coins = new int[]{1, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.change(amount, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "amount = 3, coins = [2]");
        try {
            int amount = 3;
            int[] coins = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.change(amount, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "amount = 10, coins = [10]");
        try {
            int amount = 10;
            int[] coins = new int[]{10};
            System.out.println("  Output  : " + _tcShow(_tcSol.change(amount, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}