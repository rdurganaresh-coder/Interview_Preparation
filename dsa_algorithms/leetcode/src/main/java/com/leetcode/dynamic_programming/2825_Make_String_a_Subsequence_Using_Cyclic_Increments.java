package com.leetcode.dynamic_programming;

class Solution2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, n = str2.length();
        for (char c : str1.toCharArray()) {
            char d = c == 'z' ? 'a' : (char) (c + 1);
            if (i < n && (str2.charAt(i) == c || str2.charAt(i) == d)) {
                ++i;
            }
        }
        return i == n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2825 _tcSol = new Solution2825();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "str1 = \"abc\", str2 = \"ad\"");
        try {
            String str1 = "abc";
            String str2 = "ad";
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeSubsequence(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "str1 = \"zc\", str2 = \"ad\"");
        try {
            String str1 = "zc";
            String str2 = "ad";
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeSubsequence(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "str1 = \"ab\", str2 = \"d\"");
        try {
            String str1 = "ab";
            String str2 = "d";
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeSubsequence(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}