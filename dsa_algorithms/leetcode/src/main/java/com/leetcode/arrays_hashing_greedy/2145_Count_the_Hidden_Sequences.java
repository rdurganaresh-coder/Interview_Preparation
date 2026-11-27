package com.leetcode.arrays_hashing_greedy;

class Solution2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long x = 0, mi = 0, mx = 0;
        for (int d : differences) {
            x += d;
            mi = Math.min(mi, x);
            mx = Math.max(mx, x);
        }
        return (int) Math.max(upper - lower - (mx - mi) + 1, 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2145 _tcSol = new Solution2145();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "differences = [1,-3,4], lower = 1, upper = 6");
        try {
            int[] differences = new int[]{1, -3, 4};
            int lower = 1;
            int upper = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArrays(differences, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "differences = [3,-4,5,1,-2], lower = -4, upper = 5");
        try {
            int[] differences = new int[]{3, -4, 5, 1, -2};
            int lower = -4;
            int upper = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArrays(differences, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "differences = [4,-7,2], lower = 3, upper = 6");
        try {
            int[] differences = new int[]{4, -7, 2};
            int lower = 3;
            int upper = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArrays(differences, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
