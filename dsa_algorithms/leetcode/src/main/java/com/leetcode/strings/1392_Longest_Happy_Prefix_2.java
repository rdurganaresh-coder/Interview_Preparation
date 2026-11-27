package com.leetcode.strings;

class Solution1392_2 {
    public String longestPrefix(String s) {
        s += "#";
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 2, j = 0; i < n;) {
            if (s.charAt(i - 1) == s.charAt(j)) {
                next[i++] = ++j;
            } else if (j > 0) {
                j = next[j];
            } else {
                next[i++] = 0;
            }
        }
        return s.substring(0, next[n - 1]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1392_2 _tcSol = new Solution1392_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"level\"");
        try {
            String s = "level";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPrefix(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"l\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ababab\"");
        try {
            String s = "ababab";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPrefix(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abab\"");
        System.out.println();
    }
}
