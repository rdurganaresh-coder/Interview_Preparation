package com.leetcode.sliding_window_two_pointers;

class Solution1910_2 {
    public String removeOccurrences(String s, String part) {
        int m = part.length();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            st.append(s.charAt(i));
            if (st.length() >= m && st.substring(st.length() - m).equals(part)) {
                st.setLength(st.length() - m);
            }
        }
        return st.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1910_2 _tcSol = new Solution1910_2();
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
