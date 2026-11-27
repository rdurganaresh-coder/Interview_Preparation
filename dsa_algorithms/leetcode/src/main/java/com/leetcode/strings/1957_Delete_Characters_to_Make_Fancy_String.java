package com.leetcode.strings;

class Solution1957 {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i < 2 || c != s.charAt(i - 1) || c != s.charAt(i - 2)) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1957 _tcSol = new Solution1957();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leeetcode\"");
        try {
            String s = "leeetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeFancyString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"leetcode\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaabaaaa\"");
        try {
            String s = "aaabaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeFancyString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aabaa\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aab\"");
        try {
            String s = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeFancyString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aab\"");
        System.out.println();
    }
}