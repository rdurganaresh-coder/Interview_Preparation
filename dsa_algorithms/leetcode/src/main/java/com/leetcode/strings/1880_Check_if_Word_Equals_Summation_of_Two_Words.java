package com.leetcode.strings;

class Solution1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return f(firstWord) + f(secondWord) == f(targetWord);
    }

    private int f(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans = ans * 10 + (c - 'a');
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1880 _tcSol = new Solution1880();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "firstWord = \"acb\", secondWord = \"cba\", targetWord = \"cdb\"");
        try {
            String firstWord = "acb";
            String secondWord = "cba";
            String targetWord = "cdb";
            System.out.println("  Output  : " + _tcShow(_tcSol.isSumEqual(firstWord, secondWord, targetWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "firstWord = \"aaa\", secondWord = \"a\", targetWord = \"aab\"");
        try {
            String firstWord = "aaa";
            String secondWord = "a";
            String targetWord = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.isSumEqual(firstWord, secondWord, targetWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "firstWord = \"aaa\", secondWord = \"a\", targetWord = \"aaaa\"");
        try {
            String firstWord = "aaa";
            String secondWord = "a";
            String targetWord = "aaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.isSumEqual(firstWord, secondWord, targetWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
