package com.leetcode.sql_database;

class Solution0318_2 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> mask = new HashMap<>();
        int ans = 0;
        for (var s : words) {
            int a = s.length();
            int x = 0;
            for (char c : s.toCharArray()) {
                x |= 1 << (c - 'a');
            }
            for (var e : mask.entrySet()) {
                int y = e.getKey(), b = e.getValue();
                if ((x & y) == 0) {
                    ans = Math.max(ans, a * b);
                }
            }
            mask.merge(x, a, Math::max);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0318_2 _tcSol = new Solution0318_2();
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