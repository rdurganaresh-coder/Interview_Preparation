package com.leetcode.strings;

class Solution0097_3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                int k = i + j - 1;
                if (i > 0) {
                    f[j] &= s1.charAt(i - 1) == s3.charAt(k);
                }
                if (j > 0) {
                    f[j] |= (f[j - 1] & s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0097_3 _tcSol = new Solution0097_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbcbcac\"");
        try {
            String s1 = "aabcc";
            String s2 = "dbbca";
            String s3 = "aadbbcbcac";
            System.out.println("  Output  : " + _tcShow(_tcSol.isInterleave(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbbaccc\"");
        try {
            String s1 = "aabcc";
            String s2 = "dbbca";
            String s3 = "aadbbbaccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isInterleave(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s1 = \"\", s2 = \"\", s3 = \"\"");
        try {
            String s1 = "";
            String s2 = "";
            String s3 = "";
            System.out.println("  Output  : " + _tcShow(_tcSol.isInterleave(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}