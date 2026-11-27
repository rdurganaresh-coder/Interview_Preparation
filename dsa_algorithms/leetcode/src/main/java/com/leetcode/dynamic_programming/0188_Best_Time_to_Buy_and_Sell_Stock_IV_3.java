package com.leetcode.dynamic_programming;

class Solution0188_3 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[k + 1][2];
        for (int j = 1; j <= k; ++j) {
            f[j][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = k; j > 0; --j) {
                f[j][0] = Math.max(f[j][1] + prices[i], f[j][0]);
                f[j][1] = Math.max(f[j - 1][0] - prices[i], f[j][1]);
            }
        }
        return f[k][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0188_3 _tcSol = new Solution0188_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 2, prices = [2,4,1]");
        try {
            int k = 2;
            int[] prices = new int[]{2, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(k, prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 2, prices = [3,2,6,5,0,3]");
        try {
            int k = 2;
            int[] prices = new int[]{3, 2, 6, 5, 0, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(k, prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}