package com.leetcode.arrays_hashing_greedy;

class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int cost = prices[0] + prices[1];
        return money < cost ? money : money - cost;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2706 _tcSol = new Solution2706();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [1,2,2], money = 3");
        try {
            int[] prices = new int[]{1, 2, 2};
            int money = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.buyChoco(prices, money)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [3,2,3], money = 3");
        try {
            int[] prices = new int[]{3, 2, 3};
            int money = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.buyChoco(prices, money)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}