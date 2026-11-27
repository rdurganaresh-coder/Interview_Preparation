package com.leetcode.backtracking;

class Solution1220 {
    public int countVowelPermutation(int n) {
        long[] f = new long[5];
        Arrays.fill(f, 1);
        final int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; ++i) {
            long[] g = new long[5];
            g[0] = (f[1] + f[2] + f[4]) % mod;
            g[1] = (f[0] + f[2]) % mod;
            g[2] = (f[1] + f[3]) % mod;
            g[3] = f[2];
            g[4] = (f[2] + f[3]) % mod;
            f = g;
        }
        long ans = 0;
        for (long x : f) {
            ans = (ans + x) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1220 _tcSol = new Solution1220();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelPermutation(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelPermutation(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelPermutation(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "68");
        System.out.println();
    }
}