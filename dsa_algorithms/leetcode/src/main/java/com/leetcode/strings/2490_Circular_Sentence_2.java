package com.leetcode.strings;

class Solution2490_2 {
    public boolean isCircularSentence(String s) {
        int n = s.length();
        if (s.charAt(0) != s.charAt(n - 1)) {
            return false;
        }
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != s.charAt(i + 1)) {
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
        Solution2490_2 _tcSol = new Solution2490_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"leetcode exercises sound delightful\"");
        try {
            String s = "leetcode exercises sound delightful";
            System.out.println("  Output  : " + _tcShow(_tcSol.isCircularSentence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"eetcode\"");
        try {
            String s = "eetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.isCircularSentence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence = \"Leetcode is cool\"");
        try {
            String s = "Leetcode is cool";
            System.out.println("  Output  : " + _tcShow(_tcSol.isCircularSentence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}