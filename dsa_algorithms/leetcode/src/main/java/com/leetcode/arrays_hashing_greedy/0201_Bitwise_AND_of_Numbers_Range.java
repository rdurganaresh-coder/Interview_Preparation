package com.leetcode.arrays_hashing_greedy;

class Solution0201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0201 _tcSol = new Solution0201();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "left = 5, right = 7");
        try {
            int left = 5;
            int right = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeBitwiseAnd(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "left = 0, right = 0");
        try {
            int left = 0;
            int right = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeBitwiseAnd(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "left = 1, right = 2147483647");
        try {
            int left = 1;
            int right = 2147483647;
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeBitwiseAnd(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}