package com.leetcode.bit_manipulation_math;

class Solution2457 {
    public long makeIntegerBeautiful(long n, int target) {
        long x = 0;
        while (f(n + x) > target) {
            long y = n + x;
            long p = 10;
            while (y % 10 == 0) {
                y /= 10;
                p *= 10;
            }
            x = (y / 10 + 1) * p - n;
        }
        return x;
    }

    private int f(long x) {
        int y = 0;
        while (x > 0) {
            y += x % 10;
            x /= 10;
        }
        return y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2457 _tcSol = new Solution2457();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 16, target = 6");
        try {
            long n = 16L;
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeIntegerBeautiful(n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 467, target = 6");
        try {
            long n = 467L;
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeIntegerBeautiful(n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "33");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1, target = 1");
        try {
            long n = 1L;
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeIntegerBeautiful(n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}