package com.leetcode.strings;

class Solution0186 {
    public void reverseWords(char[] s) {
        int n = s.length;
        for (int i = 0, j = 0; j < n; ++j) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            } else if (j == n - 1) {
                reverse(s, i, j);
            }
        }
        reverse(s, 0, n - 1);
    }

    private void reverse(char[] s, int i, int j) {
        for (; i < j; ++i, --j) {
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
        Solution0186 _tcSol = new Solution0186();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = [\"t\",\"h\",\"e\",\" \",\"s\",\"k\",\"y\",\" \",\"i\",\"s\",\" \",\"b\",\"l\",\"u\",\"e\"]");
        try {
            char[] s = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
            _tcSol.reverseWords(s);
            System.out.println("  Output  : " + _tcShow(s));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"b\",\"l\",\"u\",\"e\",\" \",\"i\",\"s\",\" \",\"s\",\"k\",\"y\",\" \",\"t\",\"h\",\"e\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = [\"a\"]");
        try {
            char[] s = new char[]{'a'};
            _tcSol.reverseWords(s);
            System.out.println("  Output  : " + _tcShow(s));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\"]");
        System.out.println();
    }
}