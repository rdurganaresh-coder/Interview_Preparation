package com.leetcode.sliding_window_two_pointers;

class Solution2083 {
    public long numberOfSubstrings(String s) {
        int[] cnt = new int[26];
        long ans = 0;
        for (char c : s.toCharArray()) {
            ans += ++cnt[c - 'a'];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2083 _tcSol = new Solution2083();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcba\"");
        try {
            String s = "abcba";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abacad\"");
        try {
            String s = "abacad";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a\"");
        try {
            String s = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
