package com.leetcode.sliding_window_two_pointers;

class Solution2697 {
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; ++i, --j) {
            cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
        }
        return new String(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2697 _tcSol = new Solution2697();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"egcfe\"");
        try {
            String s = "egcfe";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSmallestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"efcfe\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\"");
        try {
            String s = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSmallestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abba\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"seven\"");
        try {
            String s = "seven";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSmallestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"neven\"");
        System.out.println();
    }
}