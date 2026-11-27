package com.leetcode.bit_manipulation_math;

class Solution0367_2 {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0367_2 _tcSol = new Solution0367_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 16");
        try {
            int num = 16;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPerfectSquare(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 14");
        try {
            int num = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPerfectSquare(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}