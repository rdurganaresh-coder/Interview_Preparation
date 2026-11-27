package com.leetcode.strings;

class Solution0791_2 {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char c = order.charAt(i);
            while (cnt[c - 'a']-- > 0) {
                ans.append(c);
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (cnt[i]-- > 0) {
                ans.append((char) ('a' + i));
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0791_2 _tcSol = new Solution0791_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "order = \"cba\", s = \"abcd\"");
        try {
            String order = "cba";
            String s = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.customSortString(order, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cbad\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "order = \"bcafg\", s = \"abcd\"");
        try {
            String order = "bcafg";
            String s = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.customSortString(order, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bcad\"");
        System.out.println();
    }
}