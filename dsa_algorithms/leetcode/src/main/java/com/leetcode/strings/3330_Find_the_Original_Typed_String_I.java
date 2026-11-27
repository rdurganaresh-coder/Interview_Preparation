package com.leetcode.strings;

class Solution3330 {
    public int possibleStringCount(String word) {
        int f = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++f;
            }
        }
        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3330 _tcSol = new Solution3330();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abbcccc\"");
        try {
            String word = "abbcccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleStringCount(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abcd\"");
        try {
            String word = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleStringCount(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"aaaa\"");
        try {
            String word = "aaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleStringCount(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
