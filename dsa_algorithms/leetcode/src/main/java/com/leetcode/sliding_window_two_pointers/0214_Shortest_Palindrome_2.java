package com.leetcode.sliding_window_two_pointers;

class Solution0214_2 {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        char[] t = (s + "#" + rev + "$").toCharArray();
        int n = t.length;
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 2, j = 0; i < n;) {
            if (t[i - 1] == t[j]) {
                next[i++] = ++j;
            } else if (j > 0) {
                j = next[j];
            } else {
                next[i++] = 0;
            }
        }
        return rev.substring(0, s.length() - next[n - 1]) + s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0214_2 _tcSol = new Solution0214_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aacecaaa\"");
        try {
            String s = "aacecaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaacecaaa\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\"");
        try {
            String s = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dcbabcd\"");
        System.out.println();
    }
}
