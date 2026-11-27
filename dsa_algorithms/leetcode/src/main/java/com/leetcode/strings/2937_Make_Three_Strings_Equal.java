package com.leetcode.strings;

class Solution2937 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int s = s1.length() + s2.length() + s3.length();
        int n = Math.min(Math.min(s1.length(), s2.length()), s3.length());
        for (int i = 0; i < n; ++i) {
            if (!(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))) {
                return i == 0 ? -1 : s - 3 * i;
            }
        }
        return s - 3 * n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2937 _tcSol = new Solution2937();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"abc\", s2 = \"abb\", s3 = \"ab\"");
        try {
            String s1 = "abc";
            String s2 = "abb";
            String s3 = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinimumOperations(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"dac\", s2 = \"bac\", s3 = \"cac\"");
        try {
            String s1 = "dac";
            String s2 = "bac";
            String s3 = "cac";
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinimumOperations(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}