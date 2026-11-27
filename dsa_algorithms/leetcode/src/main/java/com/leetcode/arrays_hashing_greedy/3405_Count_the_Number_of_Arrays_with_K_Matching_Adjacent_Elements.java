package com.leetcode.arrays_hashing_greedy;

class Solution3405 {
    private static final int N = (int) 1e5 + 10;
    private static final int MOD = (int) 1e9 + 7;
    private static final long[] f = new long[N];
    private static final long[] g = new long[N];

    static {
        f[0] = 1;
        g[0] = 1;
        for (int i = 1; i < N; ++i) {
            f[i] = f[i - 1] * i % MOD;
            g[i] = qpow(f[i], MOD - 2);
        }
    }

    public static long qpow(long a, int k) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) {
                res = res * a % MOD;
            }
            k >>= 1;
            a = a * a % MOD;
        }
        return res;
    }

    public static long comb(int m, int n) {
        return (int) f[m] * g[n] % MOD * g[m - n] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        return (int) (comb(n - 1, k) * m % MOD * qpow(m - 1, n - k - 1) % MOD);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3405 _tcSol = new Solution3405();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, m = 2, k = 1");
        try {
            int n = 3;
            int m = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, m = 2, k = 2");
        try {
            int n = 4;
            int m = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, m = 2, k = 0");
        try {
            int n = 5;
            int m = 2;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodArrays(n, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}