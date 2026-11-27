package com.leetcode.bit_manipulation_math;

class Solution1812 {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1812 _tcSol = new Solution1812();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coordinates = \"a1\"");
        try {
            String coordinates = "a1";
            System.out.println("  Output  : " + _tcShow(_tcSol.squareIsWhite(coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coordinates = \"h3\"");
        try {
            String coordinates = "h3";
            System.out.println("  Output  : " + _tcShow(_tcSol.squareIsWhite(coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "coordinates = \"c7\"");
        try {
            String coordinates = "c7";
            System.out.println("  Output  : " + _tcShow(_tcSol.squareIsWhite(coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}