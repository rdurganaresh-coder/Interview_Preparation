package com.leetcode.arrays_hashing_greedy;

class Solution0940 {
    public int distinctSubseqII(String s) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int x = 1;
            for (int v : f) {
                x = (x + v) % mod;
            }
            f[s.charAt(i) - 'a'] = x;
        }
        int ans = 0;
        for (int v : f) {
            ans = (ans + v) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0940 _tcSol = new Solution0940();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\"");
        try {
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctSubseqII(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aba\"");
        try {
            String s = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctSubseqII(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aaa\"");
        try {
            String s = "aaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctSubseqII(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
