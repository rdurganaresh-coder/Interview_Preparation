package com.leetcode.arrays_hashing_greedy;

class Solution1323 {
    public int maximum69Number(int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1323 _tcSol = new Solution1323();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 9669");
        try {
            int num = 9669;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximum69Number(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9969");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 9996");
        try {
            int num = 9996;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximum69Number(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9999");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 9999");
        try {
            int num = 9999;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximum69Number(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9999");
        System.out.println();
    }
}