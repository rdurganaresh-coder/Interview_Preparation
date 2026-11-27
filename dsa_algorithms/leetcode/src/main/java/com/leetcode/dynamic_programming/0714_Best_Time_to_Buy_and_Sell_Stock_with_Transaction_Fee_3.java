package com.leetcode.dynamic_programming;

class Solution0714_3 {
    public int maxProfit(int[] prices, int fee) {
        int f0 = 0, f1 = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int g0 = Math.max(f0, f1 + prices[i] - fee);
            f1 = Math.max(f1, f0 - prices[i]);
            f0 = g0;
        }
        return f0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0714_3 _tcSol = new Solution0714_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [1,3,2,8,4,9], fee = 2");
        try {
            int[] prices = new int[]{1, 3, 2, 8, 4, 9};
            int fee = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, fee)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,3,7,5,10,3], fee = 3");
        try {
            int[] prices = new int[]{1, 3, 7, 5, 10, 3};
            int fee = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, fee)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}