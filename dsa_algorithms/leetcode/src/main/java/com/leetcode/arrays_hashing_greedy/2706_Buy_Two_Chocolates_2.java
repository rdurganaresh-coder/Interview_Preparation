package com.leetcode.arrays_hashing_greedy;

class Solution2706_2 {
    public int buyChoco(int[] prices, int money) {
        int a = 1000, b = 1000;
        for (int x : prices) {
            if (x < a) {
                b = a;
                a = x;
            } else if (x < b) {
                b = x;
            }
        }
        int cost = a + b;
        return money < cost ? money : money - cost;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2706_2 _tcSol = new Solution2706_2();
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