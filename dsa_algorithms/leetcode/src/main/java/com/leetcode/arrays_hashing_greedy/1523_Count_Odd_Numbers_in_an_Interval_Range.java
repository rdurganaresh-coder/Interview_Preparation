package com.leetcode.arrays_hashing_greedy;

class Solution1523 {
    public int countOdds(int low, int high) {
        return ((high + 1) >> 1) - (low >> 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1523 _tcSol = new Solution1523();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "low = 3, high = 7");
        try {
            int low = 3;
            int high = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOdds(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "low = 8, high = 10");
        try {
            int low = 8;
            int high = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOdds(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}