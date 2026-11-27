package com.leetcode.strings;

class Solution0344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0344 _tcSol = new Solution0344();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = [\"h\",\"e\",\"l\",\"l\",\"o\"]");
        try {
            char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
            _tcSol.reverseString(s);
            System.out.println("  Output  : " + _tcShow(s));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"o\",\"l\",\"l\",\"e\",\"h\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = [\"H\",\"a\",\"n\",\"n\",\"a\",\"h\"]");
        try {
            char[] s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
            _tcSol.reverseString(s);
            System.out.println("  Output  : " + _tcShow(s));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"h\",\"a\",\"n\",\"n\",\"a\",\"H\"]");
        System.out.println();
    }
}