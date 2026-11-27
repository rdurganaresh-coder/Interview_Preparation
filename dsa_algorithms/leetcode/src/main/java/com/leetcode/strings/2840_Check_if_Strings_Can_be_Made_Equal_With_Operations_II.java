package com.leetcode.strings;

class Solution2840 {
    public boolean checkStrings(String s1, String s2) {
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
        Solution2840 _tcSol = new Solution2840();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"abcdba\", s2 = \"cabdab\"");
        try {
            String s1 = "abcdba";
            String s2 = "cabdab";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkStrings(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"abe\", s2 = \"bea\"");
        try {
            String s1 = "abe";
            String s2 = "bea";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkStrings(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
