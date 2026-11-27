package com.leetcode.strings;

class Solution2546 {
    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2546 _tcSol = new Solution2546();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1010\", target = \"0110\"");
        try {
            String s = "1010";
            String target = "0110";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeStringsEqual(s, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"11\", target = \"00\"");
        try {
            String s = "11";
            String target = "00";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeStringsEqual(s, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}