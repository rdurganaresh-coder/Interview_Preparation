package com.leetcode.dynamic_programming;

class Solution1081 {
    public String smallestSubsequence(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            ++cnt[c - 'a'];
        }
        boolean[] vis = new boolean[26];
        char[] cs = new char[text.length()];
        int top = -1;
        for (char c : text.toCharArray()) {
            --cnt[c - 'a'];
            if (!vis[c - 'a']) {
                while (top >= 0 && c < cs[top] && cnt[cs[top] - 'a'] > 0) {
                    vis[cs[top--] - 'a'] = false;
                }
                cs[++top] = c;
                vis[c - 'a'] = true;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1081 _tcSol = new Solution1081();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"bcabc\"");
        try {
            String text = "bcabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestSubsequence(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cbacdcbc\"");
        try {
            String text = "cbacdcbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestSubsequence(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"acdb\"");
        System.out.println();
    }
}