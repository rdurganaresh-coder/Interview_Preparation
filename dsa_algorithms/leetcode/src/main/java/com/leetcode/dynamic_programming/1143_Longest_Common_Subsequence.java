package com.leetcode.dynamic_programming;

class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
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
        Solution1143 _tcSol = new Solution1143();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text1 = \"abcde\", text2 = \"ace\"");
        try {
            String text1 = "abcde";
            String text2 = "ace";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubsequence(text1, text2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text1 = \"abc\", text2 = \"abc\"");
        try {
            String text1 = "abc";
            String text2 = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubsequence(text1, text2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "text1 = \"abc\", text2 = \"def\"");
        try {
            String text1 = "abc";
            String text2 = "def";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubsequence(text1, text2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}