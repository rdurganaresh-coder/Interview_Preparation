package com.leetcode.dynamic_programming;

class Solution0521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0521 _tcSol = new Solution0521();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = \"aba\", b = \"cdc\"");
        try {
            String a = "aba";
            String b = "cdc";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLUSlength(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = \"aaa\", b = \"bbb\"");
        try {
            String a = "aaa";
            String b = "bbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLUSlength(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = \"aaa\", b = \"aaa\"");
        try {
            String a = "aaa";
            String b = "aaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.findLUSlength(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}