package com.leetcode.dynamic_programming;

class Solution3573 {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] f = new long[n][k + 1][3];
        for (int j = 1; j <= k; ++j) {
            f[0][j][1] = -prices[0];
            f[0][j][2] = prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                f[i][j][0] = Math.max(f[i - 1][j][0],
                    Math.max(f[i - 1][j][1] + prices[i], f[i - 1][j][2] - prices[i]));
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i]);
                f[i][j][2] = Math.max(f[i - 1][j][2], f[i - 1][j - 1][0] + prices[i]);
            }
        }
        return f[n - 1][k][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3573 _tcSol = new Solution3573();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [1,7,9,8,2], k = 2");
        try {
            int[] prices = new int[]{1, 7, 9, 8, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProfit(prices, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [12,16,19,19,8,1,19,13,9], k = 3");
        try {
            int[] prices = new int[]{12, 16, 19, 19, 8, 1, 19, 13, 9};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProfit(prices, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "36");
        System.out.println();
    }
}