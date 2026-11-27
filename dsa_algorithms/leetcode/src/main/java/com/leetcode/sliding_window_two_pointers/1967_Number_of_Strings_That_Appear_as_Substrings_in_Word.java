package com.leetcode.sliding_window_two_pointers;

class Solution1967 {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String p : patterns) {
            if (word.contains(p)) {
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
        Solution1967 _tcSol = new Solution1967();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "patterns = [\"a\",\"abc\",\"bc\",\"d\"], word = \"abc\"");
        try {
            String[] patterns = new String[]{"a", "abc", "bc", "d"};
            String word = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfStrings(patterns, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "patterns = [\"a\",\"b\",\"c\"], word = \"aaaaabbbbb\"");
        try {
            String[] patterns = new String[]{"a", "b", "c"};
            String word = "aaaaabbbbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfStrings(patterns, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "patterns = [\"a\",\"a\",\"a\"], word = \"ab\"");
        try {
            String[] patterns = new String[]{"a", "a", "a"};
            String word = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfStrings(patterns, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}