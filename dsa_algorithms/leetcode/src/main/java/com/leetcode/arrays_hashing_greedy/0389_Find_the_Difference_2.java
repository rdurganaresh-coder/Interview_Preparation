package com.leetcode.arrays_hashing_greedy;

class Solution0389_2 {
    public char findTheDifference(String s, String t) {
        int ss = 0;
        for (int i = 0; i < t.length(); ++i) {
            ss += t.charAt(i);
        }
        for (int i = 0; i < s.length(); ++i) {
            ss -= s.charAt(i);
        }
        return (char) ss;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0389_2 _tcSol = new Solution0389_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"abcde\"");
        try {
            String s = "abcd";
            String t = "abcde";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheDifference(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"e\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"\", t = \"y\"");
        try {
            String s = "";
            String t = "y";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheDifference(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"y\"");
        System.out.println();
    }
}