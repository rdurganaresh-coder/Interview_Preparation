package com.leetcode.dynamic_programming;

class Solution0122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0122 _tcSol = new Solution0122();
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