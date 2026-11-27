package com.leetcode.arrays_hashing_greedy;

class Solution2907 {
    public int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        int ans = -1;
        for (int j = 0; j < n; ++j) {
            int left = 0, right = 0;
            for (int i = 0; i < j; ++i) {
                if (prices[i] < prices[j]) {
                    left = Math.max(left, profits[i]);
                }
            }
            for (int k = j + 1; k < n; ++k) {
                if (prices[j] < prices[k]) {
                    right = Math.max(right, profits[k]);
                }
            }
            if (left > 0 && right > 0) {
                ans = Math.max(ans, left + profits[j] + right);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2907 _tcSol = new Solution2907();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [10,2,3,4], profits = [100,2,7,10]");
        try {
            int[] prices = new int[]{10, 2, 3, 4};
            int[] profits = new int[]{100, 2, 7, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, profits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,2,3,4,5], profits = [1,5,3,4,6]");
        try {
            int[] prices = new int[]{1, 2, 3, 4, 5};
            int[] profits = new int[]{1, 5, 3, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, profits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [4,3,2,1], profits = [33,20,19,87]");
        try {
            int[] prices = new int[]{4, 3, 2, 1};
            int[] profits = new int[]{33, 20, 19, 87};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, profits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}