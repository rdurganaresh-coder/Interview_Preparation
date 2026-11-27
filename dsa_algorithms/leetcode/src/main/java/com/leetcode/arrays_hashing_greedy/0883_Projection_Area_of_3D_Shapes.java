package com.leetcode.arrays_hashing_greedy;

class Solution0883 {
    public int projectionArea(int[][] grid) {
        int xy = 0, yz = 0, zx = 0;
        for (int i = 0, n = grid.length; i < n; ++i) {
            int maxYz = 0;
            int maxZx = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    ++xy;
                }
                maxYz = Math.max(maxYz, grid[i][j]);
                maxZx = Math.max(maxZx, grid[j][i]);
            }
            yz += maxYz;
            zx += maxZx;
        }
        return xy + yz + zx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0883 _tcSol = new Solution0883();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.projectionArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[2]]");
        try {
            int[][] grid = new int[][]{new int[]{2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.projectionArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,0],[0,2]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.projectionArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}