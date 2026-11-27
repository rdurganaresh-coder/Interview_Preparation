package com.leetcode.dynamic_programming;

class Solution2486 {
    public int appendCharacters(String s, String t) {
        int n = t.length(), j = 0;
        for (int i = 0; i < s.length() && j < n; ++i) {
            if (s.charAt(i) == t.charAt(j)) {
                ++j;
            }
        }
        return n - j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2486 _tcSol = new Solution2486();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"coaching\", t = \"coding\"");
        try {
            String s = "coaching";
            String t = "coding";
            System.out.println("  Output  : " + _tcShow(_tcSol.appendCharacters(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcde\", t = \"a\"");
        try {
            String s = "abcde";
            String t = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.appendCharacters(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"z\", t = \"abcde\"");
        try {
            String s = "z";
            String t = "abcde";
            System.out.println("  Output  : " + _tcShow(_tcSol.appendCharacters(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}