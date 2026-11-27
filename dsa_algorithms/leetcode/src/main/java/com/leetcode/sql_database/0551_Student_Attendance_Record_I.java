package com.leetcode.sql_database;

class Solution0551 {
    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0551 _tcSol = new Solution0551();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"PPALLP\"");
        try {
            String s = "PPALLP";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkRecord(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"PPALLL\"");
        try {
            String s = "PPALLL";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkRecord(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}