package com.leetcode.dynamic_programming;

class Solution0322 {
    public int coinChange(int[] coins, int amount) {
        final int inf = 1 << 30;
        int m = coins.length;
        int n = amount;
        int[][] f = new int[m + 1][n + 1];
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1]) {
                    f[i][j] = Math.min(f[i][j], f[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return f[m][n] >= inf ? -1 : f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0322 _tcSol = new Solution0322();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coins = [1,2,5], amount = 11");
        try {
            int[] coins = new int[]{1, 2, 5};
            int amount = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.coinChange(coins, amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coins = [2], amount = 3");
        try {
            int[] coins = new int[]{2};
            int amount = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.coinChange(coins, amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "coins = [1], amount = 0");
        try {
            int[] coins = new int[]{1};
            int amount = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.coinChange(coins, amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}