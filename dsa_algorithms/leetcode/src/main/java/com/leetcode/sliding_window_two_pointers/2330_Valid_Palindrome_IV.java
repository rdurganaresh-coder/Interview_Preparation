package com.leetcode.sliding_window_two_pointers;

class Solution2330 {
    public boolean makePalindrome(String s) {
        int cnt = 0;
        int i = 0, j = s.length() - 1;
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                ++cnt;
            }
        }
        return cnt <= 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2330 _tcSol = new Solution2330();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcdba\"");
        try {
            String s = "abcdba";
            System.out.println("  Output  : " + _tcShow(_tcSol.makePalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aa\"");
        try {
            String s = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.makePalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcdef\"");
        try {
            String s = "abcdef";
            System.out.println("  Output  : " + _tcShow(_tcSol.makePalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}