package com.leetcode.bit_manipulation_math;

class Solution0258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0258 _tcSol = new Solution0258();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 38");
        try {
            int num = 38;
            System.out.println("  Output  : " + _tcShow(_tcSol.addDigits(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 0");
        try {
            int num = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.addDigits(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}