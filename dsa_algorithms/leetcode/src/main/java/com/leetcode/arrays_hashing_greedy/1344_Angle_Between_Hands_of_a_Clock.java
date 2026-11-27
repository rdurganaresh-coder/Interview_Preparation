package com.leetcode.arrays_hashing_greedy;

class Solution1344 {
    public double angleClock(int hour, int minutes) {
        double h = 30 * hour + 0.5 * minutes;
        double m = 6 * minutes;
        double diff = Math.abs(h - m);
        return Math.min(diff, 360 - diff);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1344 _tcSol = new Solution1344();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hour = 12, minutes = 30");
        try {
            int hour = 12;
            int minutes = 30;
            System.out.println("  Output  : " + _tcShow(_tcSol.angleClock(hour, minutes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "165");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hour = 3, minutes = 30");
        try {
            int hour = 3;
            int minutes = 30;
            System.out.println("  Output  : " + _tcShow(_tcSol.angleClock(hour, minutes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "75");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "hour = 3, minutes = 15");
        try {
            int hour = 3;
            int minutes = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.angleClock(hour, minutes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7.5");
        System.out.println();
    }
}