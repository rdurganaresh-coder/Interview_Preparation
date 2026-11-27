package com.leetcode.arrays_hashing_greedy;

class Solution1185_2 {
    public String dayOfTheWeek(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int c = y / 100;
        y %= 100;
        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday"}[(w + 7) % 7];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1185_2 _tcSol = new Solution1185_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "day = 31, month = 8, year = 2019");
        try {
            int d = 31;
            int m = 8;
            int y = 2019;
            System.out.println("  Output  : " + _tcShow(_tcSol.dayOfTheWeek(d, m, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Saturday\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "day = 18, month = 7, year = 1999");
        try {
            int d = 18;
            int m = 7;
            int y = 1999;
            System.out.println("  Output  : " + _tcShow(_tcSol.dayOfTheWeek(d, m, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Sunday\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "day = 15, month = 8, year = 1993");
        try {
            int d = 15;
            int m = 8;
            int y = 1993;
            System.out.println("  Output  : " + _tcShow(_tcSol.dayOfTheWeek(d, m, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Sunday\"");
        System.out.println();
    }
}