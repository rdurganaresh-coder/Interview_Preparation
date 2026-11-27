package com.leetcode.sliding_window_two_pointers;

class Solution1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] g = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                g[i][j] = s.charAt(i) != s.charAt(j) ? 1 : 0;
                if (i + 1 < j) {
                    g[i][j] += g[i + 1][j - 1];
                }
            }
        }
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(i, k); ++j) {
                if (j == 1) {
                    f[i][j] = g[0][i - 1];
                } else {
                    f[i][j] = 10000;
                    for (int h = j - 1; h < i; ++h) {
                        f[i][j] = Math.min(f[i][j], f[h][j - 1] + g[h][i - 1]);
                    }
                }
            }
        }
        return f[n][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1278 _tcSol = new Solution1278();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", k = 2");
        try {
            String s = "abc";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aabbc\", k = 3");
        try {
            String s = "aabbc";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"leetcode\", k = 8");
        try {
            String s = "leetcode";
            int k = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.palindromePartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}