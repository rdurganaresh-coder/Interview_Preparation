package com.leetcode.strings;

class Solution2255 {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String w : words) {
            if (s.startsWith(w)) {
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2255 _tcSol = new Solution2255();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"c\",\"ab\",\"bc\",\"abc\"], s = \"abc\"");
        try {
            String[] words = new String[]{"a", "b", "c", "ab", "bc", "abc"};
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixes(words, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"a\"], s = \"aa\"");
        try {
            String[] words = new String[]{"a", "a"};
            String s = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrefixes(words, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}