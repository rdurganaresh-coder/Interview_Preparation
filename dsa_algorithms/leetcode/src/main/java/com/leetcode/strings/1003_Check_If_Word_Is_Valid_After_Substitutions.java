package com.leetcode.strings;

class Solution1003 {
    public boolean isValid(String s) {
        if (s.length() % 3 > 0) {
            return false;
        }
        StringBuilder t = new StringBuilder();
        for (char c : s.toCharArray()) {
            t.append(c);
            if (t.length() >= 3 && "abc".equals(t.substring(t.length() - 3))) {
                t.delete(t.length() - 3, t.length());
            }
        }
        return t.isEmpty();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1003 _tcSol = new Solution1003();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aabcbc\"");
        try {
            String s = "aabcbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcabcababcc\"");
        try {
            String s = "abcabcababcc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abccba\"");
        try {
            String s = "abccba";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}