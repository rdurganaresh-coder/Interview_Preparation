package com.leetcode.strings;

class Solution1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0 || Math.abs(sb.charAt(sb.length() - 1) - c) != 32) {
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1544 _tcSol = new Solution1544();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leEeetcode\"");
        try {
            String s = "leEeetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeGood(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"leetcode\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abBAcC\"");
        try {
            String s = "abBAcC";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeGood(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"s\"");
        try {
            String s = "s";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeGood(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"s\"");
        System.out.println();
    }
}