package com.leetcode.strings;

class Solution1961 {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder t = new StringBuilder();
        for (var w : words) {
            t.append(w);
            if (t.length() > s.length()) {
                return false;
            }
            if (t.length() == s.length()) {
                return s.equals(t.toString());
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1961 _tcSol = new Solution1961();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"iloveleetcode\", words = [\"i\",\"love\",\"leetcode\",\"apples\"]");
        try {
            String s = "iloveleetcode";
            String[] words = new String[]{"i", "love", "leetcode", "apples"};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPrefixString(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"iloveleetcode\", words = [\"apples\",\"i\",\"love\",\"leetcode\"]");
        try {
            String s = "iloveleetcode";
            String[] words = new String[]{"apples", "i", "love", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPrefixString(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}