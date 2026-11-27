package com.leetcode.dynamic_programming;

class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int a = 0;
        for (int p : position) {
            a += p % 2;
        }
        int b = position.length - a;
        return Math.min(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1217 _tcSol = new Solution1217();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "position = [1,2,3]");
        try {
            int[] position = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostToMoveChips(position)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "position = [2,2,2,3,3]");
        try {
            int[] position = new int[]{2, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostToMoveChips(position)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "position = [1,1000000000]");
        try {
            int[] position = new int[]{1, 1000000000};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostToMoveChips(position)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}