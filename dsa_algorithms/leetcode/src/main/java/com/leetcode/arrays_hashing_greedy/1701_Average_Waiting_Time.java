package com.leetcode.arrays_hashing_greedy;

class Solution1701 {
    public double averageWaitingTime(int[][] customers) {
        double tot = 0;
        int t = 0;
        for (var e : customers) {
            int a = e[0], b = e[1];
            t = Math.max(t, a) + b;
            tot += t - a;
        }
        return tot / customers.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1701 _tcSol = new Solution1701();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "customers = [[1,2],[2,5],[4,3]]");
        try {
            int[][] customers = new int[][]{new int[]{1, 2}, new int[]{2, 5}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageWaitingTime(customers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "customers = [[5,2],[5,4],[10,3],[20,1]]");
        try {
            int[][] customers = new int[][]{new int[]{5, 2}, new int[]{5, 4}, new int[]{10, 3}, new int[]{20, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageWaitingTime(customers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3.25000");
        System.out.println();
    }
}