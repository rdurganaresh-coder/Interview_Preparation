package com.leetcode.strings;

class Solution0712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            f[i][0] = f[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; ++j) {
            f[0][j] = f[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j]
                        = Math.min(f[i - 1][j] + s1.charAt(i - 1), f[i][j - 1] + s2.charAt(j - 1));
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
        Solution0712 _tcSol = new Solution0712();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"sea\", s2 = \"eat\"");
        try {
            String s1 = "sea";
            String s2 = "eat";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeleteSum(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "231");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"delete\", s2 = \"leet\"");
        try {
            String s1 = "delete";
            String s2 = "leet";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeleteSum(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "403");
        System.out.println();
    }
}