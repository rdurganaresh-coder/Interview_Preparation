package com.leetcode.arrays_hashing_greedy;

class Solution2124 {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2124 _tcSol = new Solution2124();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaabbb\"");
        try {
            String s = "aaabbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abab\"");
        try {
            String s = "abab";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"bbb\"");
        try {
            String s = "bbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}