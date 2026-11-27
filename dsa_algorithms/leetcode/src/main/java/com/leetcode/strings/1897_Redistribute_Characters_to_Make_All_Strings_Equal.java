package com.leetcode.strings;

class Solution1897 {
    public boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        for (var w : words) {
            for (char c : w.toCharArray()) {
                ++cnt[c - 'a'];
            }
        }
        int n = words.length;
        for (int v : cnt) {
            if (v % n != 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1897 _tcSol = new Solution1897();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abc\",\"aabc\",\"bc\"]");
        try {
            String[] words = new String[]{"abc", "aabc", "bc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeEqual(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"ab\",\"a\"]");
        try {
            String[] words = new String[]{"ab", "a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeEqual(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
