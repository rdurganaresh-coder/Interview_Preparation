package com.leetcode.arrays_hashing_greedy;

class Solution3233 {
    static int m = 31623;
    static boolean[] primes = new boolean[m + 1];

    static {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= m; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= m; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        int lo = (int) Math.ceil(Math.sqrt(l));
        int hi = (int) Math.floor(Math.sqrt(r));
        int cnt = 0;
        for (int i = lo; i <= hi; i++) {
            if (primes[i]) {
                cnt++;
            }
        }
        return r - l + 1 - cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3233 _tcSol = new Solution3233();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "l = 5, r = 7");
        try {
            int l = 5;
            int r = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.nonSpecialCount(l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "l = 4, r = 16");
        try {
            int l = 4;
            int r = 16;
            System.out.println("  Output  : " + _tcShow(_tcSol.nonSpecialCount(l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}