package com.leetcode.strings;

class Solution1684_2 {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = f(allowed);
        int ans = 0;
        for (String w : words) {
            if ((mask | f(w)) == mask) {
                ++ans;
            }
        }
        return ans;
    }

    private int f(String w) {
        int mask = 0;
        for (int i = 0; i < w.length(); ++i) {
            mask |= 1 << (w.charAt(i) - 'a');
        }
        return mask;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1684_2 _tcSol = new Solution1684_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "allowed = \"ab\", words = [\"ad\",\"bd\",\"aaab\",\"baa\",\"badab\"]");
        try {
            String allowed = "ab";
            String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countConsistentStrings(allowed, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "allowed = \"abc\", words = [\"a\",\"b\",\"c\",\"ab\",\"ac\",\"bc\",\"abc\"]");
        try {
            String allowed = "abc";
            String[] words = new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countConsistentStrings(allowed, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "allowed = \"cad\", words = [\"cc\",\"acd\",\"b\",\"ba\",\"bac\",\"bad\",\"ac\",\"d\"]");
        try {
            String allowed = "cad";
            String[] words = new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countConsistentStrings(allowed, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}