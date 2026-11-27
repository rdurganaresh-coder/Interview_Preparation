package com.leetcode.dynamic_programming;

class Solution0121 {
    public int maxProfit(int[] prices) {
        int ans = 0, mi = prices[0];
        for (int v : prices) {
            ans = Math.max(ans, v - mi);
            mi = Math.min(mi, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0121 _tcSol = new Solution0121();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [7,1,5,3,6,4]");
        try {
            int[] prices = new int[]{7, 1, 5, 3, 6, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
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