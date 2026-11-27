package com.leetcode.dynamic_programming;

class Solution0727 {
    public String minWindow(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = j == 1 ? i : f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        int p = 0, k = m + 1;
        for (int i = 1; i <= m; ++i) {
            if (s1.charAt(i - 1) == s2.charAt(n - 1) && f[i][n] > 0) {
                int j = f[i][n] - 1;
                if (i - j < k) {
                    k = i - j;
                    p = j;
                }
            }
        }
        return k > m ? "" : s1.substring(p, p + k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0727 _tcSol = new Solution0727();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"abcdebdde\", s2 = \"bde\"");
        try {
            String s1 = "abcdebdde";
            String s2 = "bde";
            System.out.println("  Output  : " + _tcShow(_tcSol.minWindow(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bcde\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"jmeqksfrsdcmsiwvaovztaqenprpvnbstl\", s2 = \"u\"");
        try {
            String s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl";
            String s2 = "u";
            System.out.println("  Output  : " + _tcShow(_tcSol.minWindow(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}