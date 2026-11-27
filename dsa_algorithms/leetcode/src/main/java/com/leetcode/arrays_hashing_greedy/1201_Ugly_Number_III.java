package com.leetcode.arrays_hashing_greedy;

class Solution1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);
        long l = 1, r = 2000000000;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1201 _tcSol = new Solution1201();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, a = 2, b = 3, c = 5");
        try {
            int n = 3;
            int a = 2;
            int b = 3;
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.nthUglyNumber(n, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, a = 2, b = 3, c = 4");
        try {
            int n = 4;
            int a = 2;
            int b = 3;
            int c = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.nthUglyNumber(n, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, a = 2, b = 11, c = 13");
        try {
            int n = 5;
            int a = 2;
            int b = 11;
            int c = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.nthUglyNumber(n, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}