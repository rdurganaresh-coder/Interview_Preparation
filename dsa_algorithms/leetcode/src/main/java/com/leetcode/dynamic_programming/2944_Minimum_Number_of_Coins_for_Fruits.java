package com.leetcode.dynamic_programming;

class Solution2944 {
    private int[] prices;
    private int[] f;
    private int n;

    public int minimumCoins(int[] prices) {
        n = prices.length;
        f = new int[n + 1];
        this.prices = prices;
        return dfs(1);
    }

    private int dfs(int i) {
        if (i * 2 >= n) {
            return prices[i - 1];
        }
        if (f[i] == 0) {
            f[i] = 1 << 30;
            for (int j = i + 1; j <= i * 2 + 1; ++j) {
                f[i] = Math.min(f[i], prices[i - 1] + dfs(j));
            }
        }
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2944 _tcSol = new Solution2944();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [3,1,2]");
        try {
            int[] prices = new int[]{3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCoins(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,10,1,1]");
        try {
            int[] prices = new int[]{1, 10, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCoins(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [26,18,6,12,49,7,45,45]");
        try {
            int[] prices = new int[]{26, 18, 6, 12, 49, 7, 45, 45};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCoins(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "39");
        System.out.println();
    }
}