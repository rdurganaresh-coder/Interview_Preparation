package com.leetcode.arrays_hashing_greedy;

class Solution0709 {
    public String toLowerCase(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] >= 'A' && cs[i] <= 'Z') {
                cs[i] |= 32;
            }
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0709 _tcSol = new Solution0709();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"Hello\"");
        try {
            String s = "Hello";
            System.out.println("  Output  : " + _tcShow(_tcSol.toLowerCase(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"hello\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"here\"");
        try {
            String s = "here";
            System.out.println("  Output  : " + _tcShow(_tcSol.toLowerCase(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"here\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"LOVELY\"");
        try {
            String s = "LOVELY";
            System.out.println("  Output  : " + _tcShow(_tcSol.toLowerCase(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lovely\"");
        System.out.println();
    }
}