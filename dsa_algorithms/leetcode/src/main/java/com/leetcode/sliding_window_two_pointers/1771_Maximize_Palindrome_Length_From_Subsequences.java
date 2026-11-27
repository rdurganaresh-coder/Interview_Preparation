package com.leetcode.sliding_window_two_pointers;

class Solution1771 {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = 1;
        }
        int ans = 0;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length()) {
                        ans = Math.max(ans, f[i][j]);
                    }
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
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
        Solution1771 _tcSol = new Solution1771();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"cacb\", word2 = \"cbba\"");
        try {
            String word1 = "cacb";
            String word2 = "cbba";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"ab\", word2 = \"ab\"");
        try {
            String word1 = "ab";
            String word2 = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"aa\", word2 = \"bb\"");
        try {
            String word1 = "aa";
            String word2 = "bb";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}