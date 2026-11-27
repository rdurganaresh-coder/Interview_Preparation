package com.leetcode.strings;

class Solution0583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; ++j) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if (a == b) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                }
            }
        }
        return f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0583 _tcSol = new Solution0583();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"sea\", word2 = \"eat\"");
        try {
            String word1 = "sea";
            String word2 = "eat";
            System.out.println("  Output  : " + _tcShow(_tcSol.minDistance(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"leetcode\", word2 = \"etco\"");
        try {
            String word1 = "leetcode";
            String word2 = "etco";
            System.out.println("  Output  : " + _tcShow(_tcSol.minDistance(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
