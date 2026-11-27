package com.leetcode.matrices_grids;

class Solution3142 {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i + 1 < m && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
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
        Solution3142 _tcSol = new Solution3142();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,2],[1,0,2]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 2}, new int[]{1, 0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.satisfiesConditions(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.satisfiesConditions(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1],[2],[3]]");
        try {
            int[][] grid = new int[][]{new int[]{1}, new int[]{2}, new int[]{3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.satisfiesConditions(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}