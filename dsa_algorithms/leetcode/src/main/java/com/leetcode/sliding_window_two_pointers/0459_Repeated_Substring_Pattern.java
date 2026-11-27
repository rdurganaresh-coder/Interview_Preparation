package com.leetcode.sliding_window_two_pointers;

class Solution0459 {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0459 _tcSol = new Solution0459();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abab\"");
        try {
            String s = "abab";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedSubstringPattern(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aba\"");
        try {
            String s = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedSubstringPattern(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcabcabcabc\"");
        try {
            String s = "abcabcabcabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedSubstringPattern(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}