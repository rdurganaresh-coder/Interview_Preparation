package com.leetcode.arrays_hashing_greedy;

class Solution0168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0168 _tcSol = new Solution0168();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "columnNumber = 1");
        try {
            int columnNumber = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertToTitle(columnNumber)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"A\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "columnNumber = 28");
        try {
            int columnNumber = 28;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertToTitle(columnNumber)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"AB\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "columnNumber = 701");
        try {
            int columnNumber = 701;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertToTitle(columnNumber)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ZY\"");
        System.out.println();
    }
}