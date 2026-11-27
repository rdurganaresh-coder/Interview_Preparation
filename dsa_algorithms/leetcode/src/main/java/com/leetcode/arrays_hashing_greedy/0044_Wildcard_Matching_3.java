package com.leetcode.arrays_hashing_greedy;

class Solution0044_3 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j <= n; ++j) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = f[0][j - 1];
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i - 1][j] || f[i][j - 1] || f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j - 1]
                        && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
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
        Solution0044_3 _tcSol = new Solution0044_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aa\", p = \"a\"");
        try {
            String s = "aa";
            String p = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.isMatch(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aa\", p = \"*\"");
        try {
            String s = "aa";
            String p = "*";
            System.out.println("  Output  : " + _tcShow(_tcSol.isMatch(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"cb\", p = \"?a\"");
        try {
            String s = "cb";
            String p = "?a";
            System.out.println("  Output  : " + _tcShow(_tcSol.isMatch(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
