package com.leetcode.arrays_hashing_greedy;

class Solution1342_2 {

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + numberOfSteps((num & 1) == 0 ? num >> 1 : num - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1342_2 _tcSol = new Solution1342_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 14");
        try {
            int num = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSteps(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 8");
        try {
            int num = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSteps(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 123");
        try {
            int num = 123;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSteps(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}