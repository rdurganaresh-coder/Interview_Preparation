package com.leetcode.sliding_window_two_pointers;

class Solution3084 {
    public long countSubstrings(String s, char c) {
        long cnt = s.chars().filter(ch -> ch == c).count();
        return cnt + cnt * (cnt - 1) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3084 _tcSol = new Solution3084();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abada\", c = \"a\"");
        try {
            String s = "abada";
            char c = 'a';
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubstrings(s, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"zzz\", c = \"z\"");
        try {
            String s = "zzz";
            char c = 'z';
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubstrings(s, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}