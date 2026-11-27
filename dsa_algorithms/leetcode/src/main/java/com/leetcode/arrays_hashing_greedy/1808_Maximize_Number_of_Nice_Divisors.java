package com.leetcode.arrays_hashing_greedy;

class Solution1808 {
    private final int mod = (int) 1e9 + 7;

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors < 4) {
            return primeFactors;
        }
        if (primeFactors % 3 == 0) {
            return qpow(3, primeFactors / 3);
        }
        if (primeFactors % 3 == 1) {
            return (int) (4L * qpow(3, primeFactors / 3 - 1) % mod);
        }
        return 2 * qpow(3, primeFactors / 3) % mod;
    }

    private int qpow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1808 _tcSol = new Solution1808();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "primeFactors = 5");
        try {
            int primeFactors = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNiceDivisors(primeFactors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "primeFactors = 8");
        try {
            int primeFactors = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNiceDivisors(primeFactors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();
    }
}