package com.leetcode.dynamic_programming;

class Solution0309_4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 2][2];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 2; ++j) {
                int ans = f[i + 1][j];
                if (j > 0) {
                    ans = Math.max(ans, prices[i] + f[i + 2][0]);
                } else {
                    ans = Math.max(ans, -prices[i] + f[i + 1][1]);
                }
                f[i][j] = ans;
            }
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0309_4 _tcSol = new Solution0309_4();
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
