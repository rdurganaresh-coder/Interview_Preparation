package com.leetcode.strings;

class Solution2000 {
    public String reversePrefix(String word, char ch) {
        int j = word.indexOf(ch);
        if (j == -1) {
            return word;
        }
        char[] cs = word.toCharArray();
        for (int i = 0; i < j; ++i, --j) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2000 _tcSol = new Solution2000();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abcdefd\", ch = \"d\"");
        try {
            String word = "abcdefd";
            char ch = 'd';
            System.out.println("  Output  : " + _tcShow(_tcSol.reversePrefix(word, ch)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dcbaefd\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"xyxzxe\", ch = \"z\"");
        try {
            String word = "xyxzxe";
            char ch = 'z';
            System.out.println("  Output  : " + _tcShow(_tcSol.reversePrefix(word, ch)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"zxyxxe\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"abcd\", ch = \"z\"");
        try {
            String word = "abcd";
            char ch = 'z';
            System.out.println("  Output  : " + _tcShow(_tcSol.reversePrefix(word, ch)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abcd\"");
        System.out.println();
    }
}