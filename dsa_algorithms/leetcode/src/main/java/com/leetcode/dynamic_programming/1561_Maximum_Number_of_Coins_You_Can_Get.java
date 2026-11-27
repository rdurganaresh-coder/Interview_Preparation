package com.leetcode.dynamic_programming;

class Solution1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1561 _tcSol = new Solution1561();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [2,4,1,2,7,8]");
        try {
            int[] piles = new int[]{2, 4, 1, 2, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [2,4,5]");
        try {
            int[] piles = new int[]{2, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "piles = [9,8,7,6,5,1,2,3,4]");
        try {
            int[] piles = new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();
    }
}
