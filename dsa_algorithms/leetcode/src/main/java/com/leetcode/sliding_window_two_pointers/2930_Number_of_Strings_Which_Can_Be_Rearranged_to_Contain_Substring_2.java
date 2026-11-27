package com.leetcode.sliding_window_two_pointers;

class Solution2930_2 {
    private final int mod = (int) 1e9 + 7;

    public int stringCount(int n) {
        long a = qpow(25, n);
        long b = a;
        long c = (qpow(25, n) + n * qpow(25, n - 1) % mod) % mod;
        long ab = qpow(24, n);
        long ac = (qpow(24, n) + n * qpow(24, n - 1) % mod) % mod;
        long bc = ac;
        long abc = (qpow(23, n) + n * qpow(23, n - 1) % mod) % mod;
        long tot = qpow(26, n);
        return (int) ((tot - (a + b + c - ab - ac - bc + abc)) % mod + mod) % mod;
    }

    private long qpow(long a, int n) {
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
        Solution2930_2 _tcSol = new Solution2930_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "83943898");
        System.out.println();
    }
}