package com.leetcode.bit_manipulation_math;

class Solution0326_2 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0326_2 _tcSol = new Solution0326_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 27");
        try {
            int n = 27;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPowerOfThree(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 0");
        try {
            int n = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPowerOfThree(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = -1");
        try {
            int n = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPowerOfThree(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}