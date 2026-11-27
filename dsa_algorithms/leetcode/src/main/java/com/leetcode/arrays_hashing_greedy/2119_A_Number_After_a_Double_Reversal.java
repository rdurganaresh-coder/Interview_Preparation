package com.leetcode.arrays_hashing_greedy;

class Solution2119 {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2119 _tcSol = new Solution2119();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 526");
        try {
            int num = 526;
            System.out.println("  Output  : " + _tcShow(_tcSol.isSameAfterReversals(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 1800");
        try {
            int num = 1800;
            System.out.println("  Output  : " + _tcShow(_tcSol.isSameAfterReversals(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 0");
        try {
            int num = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.isSameAfterReversals(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}