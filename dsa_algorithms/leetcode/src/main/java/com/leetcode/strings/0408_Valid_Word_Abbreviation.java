package com.leetcode.strings;

class Solution0408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j = 0, x = 0;
        for (; i < m && j < n; ++j) {
            char c = abbr.charAt(j);
            if (Character.isDigit(c)) {
                if (c == '0' && x == 0) {
                    return false;
                }
                x = x * 10 + (c - '0');
            } else {
                i += x;
                x = 0;
                if (i >= m || word.charAt(i) != c) {
                    return false;
                }
                ++i;
            }
        }
        return i + x == m && j == n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0408 _tcSol = new Solution0408();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"internationalization\", abbr = \"i12iz4n\"");
        try {
            String word = "internationalization";
            String abbr = "i12iz4n";
            System.out.println("  Output  : " + _tcShow(_tcSol.validWordAbbreviation(word, abbr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"apple\", abbr = \"a2e\"");
        try {
            String word = "apple";
            String abbr = "a2e";
            System.out.println("  Output  : " + _tcShow(_tcSol.validWordAbbreviation(word, abbr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}