package com.leetcode.strings;

class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < word1.length(); ++i) {
            ++cnt1[word1.charAt(i) - 'a'];
        }
        for (int i = 0; i < word2.length(); ++i) {
            ++cnt2[word2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if ((cnt1[i] == 0) != (cnt2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cnt1, cnt2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1657 _tcSol = new Solution1657();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"abc\", word2 = \"bca\"");
        try {
            String word1 = "abc";
            String word2 = "bca";
            System.out.println("  Output  : " + _tcShow(_tcSol.closeStrings(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"a\", word2 = \"aa\"");
        try {
            String word1 = "a";
            String word2 = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.closeStrings(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"cabbba\", word2 = \"abbccc\"");
        try {
            String word1 = "cabbba";
            String word2 = "abbccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.closeStrings(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}