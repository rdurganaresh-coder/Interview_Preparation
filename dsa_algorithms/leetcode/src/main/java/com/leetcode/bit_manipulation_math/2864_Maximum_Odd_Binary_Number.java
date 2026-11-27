package com.leetcode.bit_manipulation_math;

class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        int cnt = s.length() - s.replace("1", "").length();
        return "1".repeat(cnt - 1) + "0".repeat(s.length() - cnt) + "1";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2864 _tcSol = new Solution2864();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"010\"");
        try {
            String s = "010";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumOddBinaryNumber(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"001\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0101\"");
        try {
            String s = "0101";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumOddBinaryNumber(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1001\"");
        System.out.println();
    }
}