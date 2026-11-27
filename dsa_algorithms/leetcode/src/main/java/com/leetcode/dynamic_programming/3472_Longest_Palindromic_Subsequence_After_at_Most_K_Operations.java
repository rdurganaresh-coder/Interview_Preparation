package com.leetcode.dynamic_programming;

class Solution3472 {
    private char[] s;
    private Integer[][][] f;

    public int longestPalindromicSubsequence(String s, int k) {
        this.s = s.toCharArray();
        int n = s.length();
        f = new Integer[n][n][k + 1];
        return dfs(0, n - 1, k);
    }

    private int dfs(int i, int j, int k) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int res = Math.max(dfs(i + 1, j, k), dfs(i, j - 1, k));
        int d = Math.abs(s[i] - s[j]);
        int t = Math.min(d, 26 - d);
        if (t <= k) {
            res = Math.max(res, 2 + dfs(i + 1, j - 1, k - t));
        }
        f[i][j][k] = res;
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3472 _tcSol = new Solution3472();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abced\", k = 2");
        try {
            String s = "abced";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindromicSubsequence(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaazzz\", k = 4");
        try {
            String s = "aaazzz";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindromicSubsequence(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
