package com.leetcode.dynamic_programming;

class Solution0392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0392 _tcSol = new Solution0392();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", t = \"ahbgdc\"");
        try {
            String s = "abc";
            String t = "ahbgdc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isSubsequence(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"axc\", t = \"ahbgdc\"");
        try {
            String s = "axc";
            String t = "ahbgdc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isSubsequence(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}