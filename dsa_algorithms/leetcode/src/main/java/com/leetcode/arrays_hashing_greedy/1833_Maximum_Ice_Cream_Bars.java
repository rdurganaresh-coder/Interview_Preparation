package com.leetcode.arrays_hashing_greedy;

class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        for (int i = 0; i < n; ++i) {
            if (coins < costs[i]) {
                return i;
            }
            coins -= costs[i];
        }
        return n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1833 _tcSol = new Solution1833();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "costs = [1,3,2,4,1], coins = 7");
        try {
            int[] costs = new int[]{1, 3, 2, 4, 1};
            int coins = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIceCream(costs, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "costs = [10,6,8,7,7,8], coins = 5");
        try {
            int[] costs = new int[]{10, 6, 8, 7, 7, 8};
            int coins = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIceCream(costs, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "costs = [1,6,3,1,2,5], coins = 20");
        try {
            int[] costs = new int[]{1, 6, 3, 1, 2, 5};
            int coins = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIceCream(costs, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}