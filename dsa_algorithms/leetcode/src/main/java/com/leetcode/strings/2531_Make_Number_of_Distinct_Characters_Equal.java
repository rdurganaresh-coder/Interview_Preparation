package com.leetcode.strings;

class Solution2531 {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int x = 0, y = 0;
        for (int i = 0; i < word1.length(); ++i) {
            if (++cnt1[word1.charAt(i) - 'a'] == 1) {
                ++x;
            }
        }
        for (int i = 0; i < word2.length(); ++i) {
            if (++cnt2[word2.charAt(i) - 'a'] == 1) {
                ++y;
            }
        }
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (cnt1[i] > 0 && cnt2[j] > 0) {
                    if (i == j) {
                        if (x == y) {
                            return true;
                        }
                    } else {
                        int a = x - (cnt1[i] == 1 ? 1 : 0) + (cnt1[j] == 0 ? 1 : 0);
                        int b = y - (cnt2[j] == 1 ? 1 : 0) + (cnt2[i] == 0 ? 1 : 0);
                        if (a == b) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2531 _tcSol = new Solution2531();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"ac\", word2 = \"b\"");
        try {
            String word1 = "ac";
            String word2 = "b";
            System.out.println("  Output  : " + _tcShow(_tcSol.isItPossible(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"abcc\", word2 = \"aab\"");
        try {
            String word1 = "abcc";
            String word2 = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.isItPossible(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"abcde\", word2 = \"fghij\"");
        try {
            String word1 = "abcde";
            String word2 = "fghij";
            System.out.println("  Output  : " + _tcShow(_tcSol.isItPossible(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}