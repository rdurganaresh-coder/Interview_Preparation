package com.leetcode.sql_database;

class Solution1969 {
    public int minNonZeroProduct(int p) {
        final int mod = (int) 1e9 + 7;
        long a = ((1L << p) - 1) % mod;
        long b = qpow(((1L << p) - 2) % mod, (1L << (p - 1)) - 1, mod);
        return (int) (a * b % mod);
    }

    private long qpow(long a, long n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1969 _tcSol = new Solution1969();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "p = 1");
        try {
            int p = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minNonZeroProduct(p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "p = 2");
        try {
            int p = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minNonZeroProduct(p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "p = 3");
        try {
            int p = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minNonZeroProduct(p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1512");
        System.out.println();
    }
}