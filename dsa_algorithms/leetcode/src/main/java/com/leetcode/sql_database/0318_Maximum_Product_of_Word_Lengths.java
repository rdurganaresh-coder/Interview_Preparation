package com.leetcode.sql_database;

class Solution0318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
            for (int j = 0; j < i; ++j) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
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
        Solution0318 _tcSol = new Solution0318();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abcw\",\"baz\",\"foo\",\"bar\",\"xtfn\",\"abcdef\"]");
        try {
            String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"ab\",\"abc\",\"d\",\"cd\",\"bcd\",\"abcd\"]");
        try {
            String[] words = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"a\",\"aa\",\"aaa\",\"aaaa\"]");
        try {
            String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}