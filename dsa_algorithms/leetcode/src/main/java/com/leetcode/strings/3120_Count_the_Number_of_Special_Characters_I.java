package com.leetcode.strings;

class Solution3120 {
    public int numberOfSpecialChars(String word) {
        boolean[] s = new boolean['z' + 1];
        for (int i = 0; i < word.length(); ++i) {
            s[word.charAt(i)] = true;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (s['a' + i] && s['A' + i]) {
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3120 _tcSol = new Solution3120();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aaAbcBC\"");
        try {
            String word = "aaAbcBC";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSpecialChars(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abc\"");
        try {
            String word = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSpecialChars(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"abBCab\"");
        try {
            String word = "abBCab";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSpecialChars(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}