package com.leetcode.sliding_window_two_pointers;

class Solution2472 {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (var row : g) {
            Arrays.fill(row, true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = f[i + 1];
            for (int j = i + k - 1; j < n; ++j) {
                if (g[i][j]) {
                    f[i] = Math.max(f[i], 1 + f[j + 1]);
                }
            }
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2472 _tcSol = new Solution2472();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abaccdbbd\", k = 3");
        try {
            String s = "abaccdbbd";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPalindromes(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"adbcda\", k = 2");
        try {
            String s = "adbcda";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPalindromes(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
