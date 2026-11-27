package com.leetcode.bit_manipulation_math;

class Solution0050 {
    public double myPow(double x, int n) {
        return n >= 0 ? qpow(x, n) : 1 / qpow(x, -(long) n);
    }

    private double qpow(double a, long n) {
        double ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0050 _tcSol = new Solution0050();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 2.00000, n = 10");
        try {
            double x = 2.0;
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.myPow(x, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1024.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 2.10000, n = 3");
        try {
            double x = 2.1;
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.myPow(x, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9.26100");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 2.00000, n = -2");
        try {
            double x = 2.0;
            int n = -2;
            System.out.println("  Output  : " + _tcShow(_tcSol.myPow(x, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.25000");
        System.out.println();
    }
}