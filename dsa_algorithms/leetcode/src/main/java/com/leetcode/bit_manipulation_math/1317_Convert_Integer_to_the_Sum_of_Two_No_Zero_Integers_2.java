package com.leetcode.bit_manipulation_math;

class Solution1317_2 {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1;; ++a) {
            int b = n - a;
            if (f(a) && f(b)) {
                return new int[] {a, b};
            }
        }
    }

    private boolean f(int x) {
        for (; x > 0; x /= 10) {
            if (x % 10 == 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1317_2 _tcSol = new Solution1317_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getNoZeroIntegers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 11");
        try {
            int n = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.getNoZeroIntegers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,9]");
        System.out.println();
    }
}