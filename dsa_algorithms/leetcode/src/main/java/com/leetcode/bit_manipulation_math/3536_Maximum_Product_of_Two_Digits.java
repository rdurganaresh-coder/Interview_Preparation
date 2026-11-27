package com.leetcode.bit_manipulation_math;

class Solution3536 {
    public int maxProduct(int n) {
        int a = 0, b = 0;
        for (; n > 0; n /= 10) {
            int x = n % 10;
            if (a < x) {
                b = a;
                a = x;
            } else if (b < x) {
                b = x;
            }
        }
        return a * b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3536 _tcSol = new Solution3536();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 31");
        try {
            int n = 31;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 22");
        try {
            int n = 22;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 124");
        try {
            int n = 124;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}