package com.leetcode.matrices_grids;

class Solution2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2319 _tcSol = new Solution2319();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 0, 0, 1}, new int[]{0, 3, 1, 0}, new int[]{0, 5, 2, 0}, new int[]{4, 0, 0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkXMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[5,7,0],[0,3,1],[0,5,0]]");
        try {
            int[][] grid = new int[][]{new int[]{5, 7, 0}, new int[]{0, 3, 1}, new int[]{0, 5, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkXMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}