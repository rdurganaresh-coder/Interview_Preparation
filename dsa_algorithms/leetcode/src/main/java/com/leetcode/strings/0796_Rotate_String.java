package com.leetcode.strings;

class Solution0796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0796 _tcSol = new Solution0796();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcde\", goal = \"cdeab\"");
        try {
            String s = "abcde";
            String goal = "cdeab";
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateString(s, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcde\", goal = \"abced\"");
        try {
            String s = "abcde";
            String goal = "abced";
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateString(s, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}