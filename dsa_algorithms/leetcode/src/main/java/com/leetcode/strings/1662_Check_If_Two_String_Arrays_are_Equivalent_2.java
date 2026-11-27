package com.leetcode.strings;

class Solution1662_2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
                return false;
            }
            ++j1;
            if (j1 == word1[i1].length()) {
                ++i1;
                j1 = 0;
            }
            ++j2;
            if (j2 == word2[i2].length()) {
                ++i2;
                j2 = 0;
            }
        }
        return i1 == word1.length && i2 == word2.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1662_2 _tcSol = new Solution1662_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = [\"ab\", \"c\"], word2 = [\"a\", \"bc\"]");
        try {
            String[] word1 = new String[]{"ab", "c"};
            String[] word2 = new String[]{"a", "bc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayStringsAreEqual(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = [\"a\", \"cb\"], word2 = [\"ab\", \"c\"]");
        try {
            String[] word1 = new String[]{"a", "cb"};
            String[] word2 = new String[]{"ab", "c"};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayStringsAreEqual(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = [\"abc\", \"d\", \"defg\"], word2 = [\"abcddefg\"]");
        try {
            String[] word1 = new String[]{"abc", "d", "defg"};
            String[] word2 = new String[]{"abcddefg"};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayStringsAreEqual(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
