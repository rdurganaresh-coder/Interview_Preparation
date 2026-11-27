package com.leetcode.bit_manipulation_math;

class Solution1784 {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1784 _tcSol = new Solution1784();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1001\"");
        try {
            String s = "1001";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkOnesSegment(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"110\"");
        try {
            String s = "110";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkOnesSegment(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}