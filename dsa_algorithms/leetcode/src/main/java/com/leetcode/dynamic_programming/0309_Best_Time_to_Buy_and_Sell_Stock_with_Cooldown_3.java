package com.leetcode.dynamic_programming;

class Solution0309_3 {
    public int maxProfit(int[] prices) {
        int f = 0, f0 = 0, f1 = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int g0 = Math.max(f0, f1 + prices[i]);
            f1 = Math.max(f1, f - prices[i]);
            f = f0;
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
        Solution0309_3 _tcSol = new Solution0309_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [1,2,3,0,2]");
        try {
            int[] prices = new int[]{1, 2, 3, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1]");
        try {
            int[] prices = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}