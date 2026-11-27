package com.leetcode.dynamic_programming;

class Solution0714 {
    private Integer[][] f;
    private int[] prices;
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        f = new Integer[prices.length][2];
        this.prices = prices;
        this.fee = fee;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= prices.length) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = dfs(i + 1, j);
        if (j > 0) {
            ans = Math.max(ans, prices[i] + dfs(i + 1, 0) - fee);
        } else {
            ans = Math.max(ans, -prices[i] + dfs(i + 1, 1));
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0714 _tcSol = new Solution0714();
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
