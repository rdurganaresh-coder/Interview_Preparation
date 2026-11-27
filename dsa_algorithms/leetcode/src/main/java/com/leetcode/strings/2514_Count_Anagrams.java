package com.leetcode.strings;

import java.math.BigInteger;

class Solution2514 {
    private static final int MOD = (int) 1e9 + 7;

    public int countAnagrams(String s) {
        int n = s.length();
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] * i % MOD;
        }
        long p = 1;
        for (String w : s.split(" ")) {
            int[] cnt = new int[26];
            for (int i = 0; i < w.length(); ++i) {
                ++cnt[w.charAt(i) - 'a'];
            }
            p = p * f[w.length()] % MOD;
            for (int v : cnt) {
                p = p * BigInteger.valueOf(f[v]).modInverse(BigInteger.valueOf(MOD)).intValue()
                    % MOD;
            }
        }
        return (int) p;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2514 _tcSol = new Solution2514();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"too hot\"");
        try {
            String s = "too hot";
            System.out.println("  Output  : " + _tcShow(_tcSol.countAnagrams(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aa\"");
        try {
            String s = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.countAnagrams(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}