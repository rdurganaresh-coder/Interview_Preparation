package com.leetcode.arrays_hashing_greedy;

class Solution1922 {
    private final int mod = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        return (int) (qpow(5, (n + 1) >> 1) * qpow(4, n >> 1) % mod);
    }

    private long qpow(long x, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1922 _tcSol = new Solution1922();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            long n = 1L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodNumbers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4");
        try {
            long n = 4L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodNumbers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "400");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 50");
        try {
            long n = 50L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodNumbers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "564908303");
        System.out.println();
    }
}