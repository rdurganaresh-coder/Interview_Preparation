package com.leetcode.dynamic_programming;

class Solution1332 {
    public int removePalindromeSub(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }
        }
        return 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1332 _tcSol = new Solution1332();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ababa\"");
        try {
            String s = "ababa";
            System.out.println("  Output  : " + _tcShow(_tcSol.removePalindromeSub(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abb\"");
        try {
            String s = "abb";
            System.out.println("  Output  : " + _tcShow(_tcSol.removePalindromeSub(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"baabb\"");
        try {
            String s = "baabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.removePalindromeSub(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}