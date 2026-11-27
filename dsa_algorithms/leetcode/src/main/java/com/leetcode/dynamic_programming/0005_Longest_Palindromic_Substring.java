package com.leetcode.dynamic_programming;

class Solution0005 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (var g : f) {
            Arrays.fill(g, true);
        }
        int k = 0, mx = 1;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = false;
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                    if (f[i][j] && mx < j - i + 1) {
                        mx = j - i + 1;
                        k = i;
                    }
                }
            }
        }
        return s.substring(k, k + mx);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0005 _tcSol = new Solution0005();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"babad\"");
        try {
            String s = "babad";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cbbd\"");
        try {
            String s = "cbbd";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bb\"");
        System.out.println();
    }
}