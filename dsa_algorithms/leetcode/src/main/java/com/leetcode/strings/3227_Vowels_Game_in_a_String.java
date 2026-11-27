package com.leetcode.strings;

class Solution3227 {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3227 _tcSol = new Solution3227();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcoder\"");
        try {
            String s = "leetcoder";
            System.out.println("  Output  : " + _tcShow(_tcSol.doesAliceWin(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"bbcd\"");
        try {
            String s = "bbcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.doesAliceWin(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}