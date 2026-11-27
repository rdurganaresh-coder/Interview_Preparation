package com.leetcode.dynamic_programming;

class Solution0322_2 {
    public int coinChange(int[] coins, int amount) {
        final int inf = 1 << 30;
        int n = amount;
        int[] f = new int[n + 1];
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int x : coins) {
            for (int j = x; j <= n; ++j) {
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }
        return f[n] >= inf ? -1 : f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0322_2 _tcSol = new Solution0322_2();
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