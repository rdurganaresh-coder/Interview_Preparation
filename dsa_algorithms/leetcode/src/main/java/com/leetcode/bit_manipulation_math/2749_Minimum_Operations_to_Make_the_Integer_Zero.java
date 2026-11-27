package com.leetcode.bit_manipulation_math;

class Solution2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 1;; ++k) {
            long x = num1 - k * num2;
            if (x < 0) {
                break;
            }
            if (Long.bitCount(x) <= k && k <= x) {
                return (int) k;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2749 _tcSol = new Solution2749();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = 3, num2 = -2");
        try {
            int num1 = 3;
            int num2 = -2;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeTheIntegerZero(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = 5, num2 = 7");
        try {
            int num1 = 5;
            int num2 = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeTheIntegerZero(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}