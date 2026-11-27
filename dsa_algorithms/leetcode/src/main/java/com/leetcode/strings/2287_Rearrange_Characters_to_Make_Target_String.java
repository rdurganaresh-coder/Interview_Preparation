package com.leetcode.strings;

class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt1[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < target.length(); ++i) {
            ++cnt2[target.charAt(i) - 'a'];
        }
        int ans = 100;
        for (int i = 0; i < 26; ++i) {
            if (cnt2[i] > 0) {
                ans = Math.min(ans, cnt1[i] / cnt2[i]);
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
        Solution2287 _tcSol = new Solution2287();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ilovecodingonleetcode\", target = \"code\"");
        try {
            String s = "ilovecodingonleetcode";
            String target = "code";
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeCharacters(s, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcba\", target = \"abc\"");
        try {
            String s = "abcba";
            String target = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeCharacters(s, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abbaccaddaeea\", target = \"aaaaa\"");
        try {
            String s = "abbaccaddaeea";
            String target = "aaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeCharacters(s, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}