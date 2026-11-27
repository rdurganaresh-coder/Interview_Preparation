package com.leetcode.sliding_window_two_pointers;

class Solution2734 {
    public String smallestString(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            ++i;
        }
        if (i == n) {
            return s.substring(0, n - 1) + "z";
        }
        int j = i;
        char[] cs = s.toCharArray();
        while (j < n && cs[j] != 'a') {
            cs[j] = (char) (cs[j] - 1);
            ++j;
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2734 _tcSol = new Solution2734();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"cbabc\"");
        try {
            String s = "cbabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"baabc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aa\"");
        try {
            String s = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"az\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"acbbc\"");
        try {
            String s = "acbbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abaab\"");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"leetcode\"");
        try {
            String s = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"kddsbncd\"");
        System.out.println();
    }
}