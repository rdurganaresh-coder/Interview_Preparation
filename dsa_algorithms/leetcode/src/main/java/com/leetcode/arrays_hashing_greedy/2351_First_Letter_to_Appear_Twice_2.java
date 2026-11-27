package com.leetcode.arrays_hashing_greedy;

class Solution2351_2 {
    public char repeatedCharacter(String s) {
        int mask = 0;
        for (int i = 0;; ++i) {
            char c = s.charAt(i);
            if ((mask >> (c - 'a') & 1) == 1) {
                return c;
            }
            mask |= 1 << (c - 'a');
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2351_2 _tcSol = new Solution2351_2();
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