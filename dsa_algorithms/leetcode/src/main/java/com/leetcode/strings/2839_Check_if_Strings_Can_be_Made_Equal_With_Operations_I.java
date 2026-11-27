package com.leetcode.strings;

class Solution2839 {
    public boolean canBeEqual(String s1, String s2) {
        int[][] cnt = new int[2][26];
        for (int i = 0; i < s1.length(); ++i) {
            ++cnt[i & 1][s1.charAt(i) - 'a'];
            --cnt[i & 1][s2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[0][i] != 0 || cnt[1][i] != 0) {
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
        Solution2839 _tcSol = new Solution2839();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"abcd\", s2 = \"cdab\"");
        try {
            String s1 = "abcd";
            String s2 = "cdab";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeEqual(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"abcd\", s2 = \"dacb\"");
        try {
            String s1 = "abcd";
            String s2 = "dacb";
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeEqual(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}