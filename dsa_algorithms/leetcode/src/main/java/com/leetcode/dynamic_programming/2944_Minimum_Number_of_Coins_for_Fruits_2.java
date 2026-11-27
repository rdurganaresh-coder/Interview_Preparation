package com.leetcode.dynamic_programming;

class Solution2944_2 {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        for (int i = (n - 1) / 2; i > 0; --i) {
            int mi = 1 << 30;
            for (int j = i; j <= i * 2; ++j) {
                mi = Math.min(mi, prices[j]);
            }
            prices[i - 1] += mi;
        }
        return prices[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2944_2 _tcSol = new Solution2944_2();
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