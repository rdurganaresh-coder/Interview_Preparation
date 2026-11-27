package com.leetcode.arrays_hashing_greedy;

class Solution2351 {
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        for (int i = 0;; ++i) {
            char c = s.charAt(i);
            if (++cnt[c - 'a'] == 2) {
                return c;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2351 _tcSol = new Solution2351();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abccbaacz\"");
        try {
            String s = "abccbaacz";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedCharacter(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcdd\"");
        try {
            String s = "abcdd";
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedCharacter(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"d\"");
        System.out.println();
    }
}