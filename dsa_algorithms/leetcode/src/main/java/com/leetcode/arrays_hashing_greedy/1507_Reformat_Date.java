package com.leetcode.arrays_hashing_greedy;

class Solution1507 {
    public String reformatDate(String date) {
        var s = date.split(" ");
        String months = " JanFebMarAprMayJunJulAugSepOctNovDec";
        int day = Integer.parseInt(s[0].substring(0, s[0].length() - 2));
        int month = months.indexOf(s[1]) / 3 + 1;
        return String.format("%s-%02d-%02d", s[2], month, day);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1507 _tcSol = new Solution1507();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "date = \"20th Oct 2052\"");
        try {
            String date = "20th Oct 2052";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformatDate(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2052-10-20\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "date = \"6th Jun 1933\"");
        try {
            String date = "6th Jun 1933";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformatDate(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1933-06-06\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "date = \"26th May 1960\"");
        try {
            String date = "26th May 1960";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformatDate(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1960-05-26\"");
        System.out.println();
    }
}