package com.leetcode.arrays_hashing_greedy;

class Solution1118 {
    public int numberOfDays(int year, int month) {
        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int[] days = new int[] {0, 31, leap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return days[month];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1118 _tcSol = new Solution1118();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "year = 1992, month = 7");
        try {
            int year = 1992;
            int month = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfDays(year, month)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "31");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "year = 2000, month = 2");
        try {
            int year = 2000;
            int month = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfDays(year, month)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "29");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "year = 1900, month = 2");
        try {
            int year = 1900;
            int month = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfDays(year, month)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();
    }
}