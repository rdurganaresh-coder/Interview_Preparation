package com.leetcode.strings;

class Solution1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int x = (t.charAt(i) - s.charAt(i) + 26) % 26;
            ++cnt[x];
        }
        for (int i = 1; i < 26; ++i) {
            if (i + 26 * (cnt[i] - 1) > k) {
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
        Solution1540 _tcSol = new Solution1540();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"input\", t = \"ouput\", k = 9");
        try {
            String s = "input";
            String t = "ouput";
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.canConvertString(s, t, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc\", t = \"bcd\", k = 10");
        try {
            String s = "abc";
            String t = "bcd";
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.canConvertString(s, t, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aab\", t = \"bbb\", k = 27");
        try {
            String s = "aab";
            String t = "bbb";
            int k = 27;
            System.out.println("  Output  : " + _tcShow(_tcSol.canConvertString(s, t, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}