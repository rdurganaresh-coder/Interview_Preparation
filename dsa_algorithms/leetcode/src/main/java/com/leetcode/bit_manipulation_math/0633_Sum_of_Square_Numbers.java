package com.leetcode.bit_manipulation_math;

class Solution0633 {
    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c);
        while (a <= b) {
            long s = a * a + b * b;
            if (s == c) {
                return true;
            }
            if (s < c) {
                ++a;
            } else {
                --b;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0633 _tcSol = new Solution0633();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "c = 5");
        try {
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.judgeSquareSum(c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "c = 3");
        try {
            int c = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.judgeSquareSum(c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}