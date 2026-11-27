package com.leetcode.strings;

class Solution3138 {
    private int n;
    private char[] s;
    private int[] cnt = new int[26];

    public int minAnagramLength(String s) {
        n = s.length();
        this.s = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            ++cnt[this.s[i] - 'a'];
        }
        for (int i = 1;; ++i) {
            if (n % i == 0 && check(i)) {
                return i;
            }
        }
    }

    private boolean check(int k) {
        for (int i = 0; i < n; i += k) {
            int[] cnt1 = new int[26];
            for (int j = i; j < i + k; ++j) {
                ++cnt1[s[j] - 'a'];
            }
            for (int j = 0; j < 26; ++j) {
                if (cnt1[j] * (n / k) != cnt[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3138 _tcSol = new Solution3138();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abba\"");
        try {
            String s = "abba";
            System.out.println("  Output  : " + _tcShow(_tcSol.minAnagramLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cdef\"");
        try {
            String s = "cdef";
            System.out.println("  Output  : " + _tcShow(_tcSol.minAnagramLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcbcacabbaccba\"");
        try {
            String s = "abcbcacabbaccba";
            System.out.println("  Output  : " + _tcShow(_tcSol.minAnagramLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}