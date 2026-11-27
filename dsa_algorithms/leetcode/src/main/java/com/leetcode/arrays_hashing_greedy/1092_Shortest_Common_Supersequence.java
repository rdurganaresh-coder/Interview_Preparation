package com.leetcode.arrays_hashing_greedy;

class Solution1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        int i = m, j = n;
        StringBuilder ans = new StringBuilder();
        while (i > 0 || j > 0) {
            if (i == 0) {
                ans.append(str2.charAt(--j));
            } else if (j == 0) {
                ans.append(str1.charAt(--i));
            } else {
                if (f[i][j] == f[i - 1][j]) {
                    ans.append(str1.charAt(--i));
                } else if (f[i][j] == f[i][j - 1]) {
                    ans.append(str2.charAt(--j));
                } else {
                    ans.append(str1.charAt(--i));
                    --j;
                }
            }
        }
        return ans.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1092 _tcSol = new Solution1092();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "str1 = \"abac\", str2 = \"cab\"");
        try {
            String str1 = "abac";
            String str2 = "cab";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestCommonSupersequence(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cabac\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "str1 = \"aaaaaaaa\", str2 = \"aaaaaaaa\"");
        try {
            String str1 = "aaaaaaaa";
            String str2 = "aaaaaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestCommonSupersequence(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaaaaaaa\"");
        System.out.println();
    }
}