package com.leetcode.arrays_hashing_greedy;

class Solution0878 {
    private static final int MOD = (int) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = a * b / gcd(a, b);
        long l = 0, r = (long) (a + b) * n;
        while (l < r) {
            long mid = l + r >>> 1;
            if (mid / a + mid / b - mid / c >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0878 _tcSol = new Solution0878();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, a = 2, b = 3");
        try {
            int n = 1;
            int a = 2;
            int b = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.nthMagicalNumber(n, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, a = 2, b = 3");
        try {
            int n = 4;
            int a = 2;
            int b = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.nthMagicalNumber(n, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}