package com.leetcode.strings;

class Solution2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt = new int[26];
        for (int i = 0; i < word1.length(); ++i) {
            ++cnt[word1.charAt(i) - 'a'];
        }
        for (int i = 0; i < word2.length(); ++i) {
            --cnt[word2.charAt(i) - 'a'];
        }
        for (int x : cnt) {
            if (Math.abs(x) > 3) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2068 _tcSol = new Solution2068();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"aaaa\", word2 = \"bccb\"");
        try {
            String word1 = "aaaa";
            String word2 = "bccb";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkAlmostEquivalent(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"abcdeef\", word2 = \"abaaacc\"");
        try {
            String word1 = "abcdeef";
            String word2 = "abaaacc";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkAlmostEquivalent(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"cccddabba\", word2 = \"babababab\"");
        try {
            String word1 = "cccddabba";
            String word2 = "babababab";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkAlmostEquivalent(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}