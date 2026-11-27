package com.leetcode.dynamic_programming;

class Solution0122_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - prices[i]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + prices[i]);
        }
        return f[n - 1][1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0122_2 _tcSol = new Solution0122_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [7,1,5,3,6,4]");
        try {
            int[] prices = new int[]{7, 1, 5, 3, 6, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,2,3,4,5]");
        try {
            int[] prices = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [7,6,4,3,1]");
        try {
            int[] prices = new int[]{7, 6, 4, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}