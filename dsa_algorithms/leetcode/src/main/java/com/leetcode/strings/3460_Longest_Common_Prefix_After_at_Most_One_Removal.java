package com.leetcode.strings;

class Solution3460 {
    public int longestCommonPrefix(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        boolean rem = false;
        while (i < n && j < m) {
            if (s.charAt(i) != t.charAt(j)) {
                if (rem) {
                    break;
                }
                rem = true;
            } else {
                ++j;
            }
            ++i;
        }
        return j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3460 _tcSol = new Solution3460();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"madxa\", t = \"madam\"");
        try {
            String s = "madxa";
            String t = "madam";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"leetcode\", t = \"eetcode\"");
        try {
            String s = "leetcode";
            String t = "eetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"one\", t = \"one\"");
        try {
            String s = "one";
            String t = "one";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"a\", t = \"b\"");
        try {
            String s = "a";
            String t = "b";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
