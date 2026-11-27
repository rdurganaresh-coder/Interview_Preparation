package com.leetcode.sliding_window_two_pointers;

class Solution3297 {
    public long validSubstringCount(String word1, String word2) {
        if (word1.length() < word2.length()) {
            return 0;
        }
        int[] cnt = new int[26];
        int need = 0;
        for (int i = 0; i < word2.length(); ++i) {
            if (++cnt[word2.charAt(i) - 'a'] == 1) {
                ++need;
            }
        }
        long ans = 0;
        int[] win = new int[26];
        for (int l = 0, r = 0; r < word1.length(); ++r) {
            int c = word1.charAt(r) - 'a';
            if (++win[c] == cnt[c]) {
                --need;
            }
            while (need == 0) {
                c = word1.charAt(l) - 'a';
                if (win[c] == cnt[c]) {
                    ++need;
                }
                --win[c];
                ++l;
            }
            ans += l;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3297 _tcSol = new Solution3297();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"bcca\", word2 = \"abc\"");
        try {
            String word1 = "bcca";
            String word2 = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubstringCount(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"abcabc\", word2 = \"abc\"");
        try {
            String word1 = "abcabc";
            String word2 = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubstringCount(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"abcabc\", word2 = \"aaabc\"");
        try {
            String word1 = "abcabc";
            String word2 = "aaabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubstringCount(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
