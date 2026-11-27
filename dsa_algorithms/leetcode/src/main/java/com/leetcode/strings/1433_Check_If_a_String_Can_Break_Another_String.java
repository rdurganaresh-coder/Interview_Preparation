package com.leetcode.strings;

class Solution1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        return check(cs1, cs2) || check(cs2, cs1);
    }

    private boolean check(char[] cs1, char[] cs2) {
        for (int i = 0; i < cs1.length; ++i) {
            if (cs1[i] < cs2[i]) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1433 _tcSol = new Solution1433();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"abc\", s2 = \"xya\"");
        try {
            String s1 = "abc";
            String s2 = "xya";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfCanBreak(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"abe\", s2 = \"acd\"");
        try {
            String s1 = "abe";
            String s2 = "acd";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfCanBreak(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s1 = \"leetcodee\", s2 = \"interview\"");
        try {
            String s1 = "leetcodee";
            String s2 = "interview";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfCanBreak(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}