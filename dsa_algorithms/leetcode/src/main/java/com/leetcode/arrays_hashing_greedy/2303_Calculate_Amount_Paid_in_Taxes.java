package com.leetcode.arrays_hashing_greedy;

class Solution2303 {
    public double calculateTax(int[][] brackets, int income) {
        int ans = 0, prev = 0;
        for (var e : brackets) {
            int upper = e[0], percent = e[1];
            ans += Math.max(0, Math.min(income, upper) - prev) * percent;
            prev = upper;
        }
        return ans / 100.0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2303 _tcSol = new Solution2303();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "brackets = [[3,50],[7,10],[12,25]], income = 10");
        try {
            int[][] brackets = new int[][]{new int[]{3, 50}, new int[]{7, 10}, new int[]{12, 25}};
            int income = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateTax(brackets, income)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2.65000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "brackets = [[1,0],[4,25],[5,50]], income = 2");
        try {
            int[][] brackets = new int[][]{new int[]{1, 0}, new int[]{4, 25}, new int[]{5, 50}};
            int income = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateTax(brackets, income)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.25000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "brackets = [[2,50]], income = 0");
        try {
            int[][] brackets = new int[][]{new int[]{2, 50}};
            int income = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateTax(brackets, income)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.00000");
        System.out.println();
    }
}