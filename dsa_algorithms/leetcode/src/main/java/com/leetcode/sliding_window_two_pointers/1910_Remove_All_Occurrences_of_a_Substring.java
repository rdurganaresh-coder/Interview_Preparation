package com.leetcode.sliding_window_two_pointers;

class Solution1910 {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1910 _tcSol = new Solution1910();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"daabcbaabcbc\", part = \"abc\"");
        try {
            String s = "daabcbaabcbc";
            String part = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOccurrences(s, part)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"axxxxyyyyb\", part = \"xy\"");
        try {
            String s = "axxxxyyyyb";
            String part = "xy";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOccurrences(s, part)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ab\"");
        System.out.println();
    }
}