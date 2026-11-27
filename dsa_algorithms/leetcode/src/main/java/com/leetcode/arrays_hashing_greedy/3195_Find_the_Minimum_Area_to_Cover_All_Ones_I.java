package com.leetcode.arrays_hashing_greedy;

class Solution3195 {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x1 = m, y1 = n;
        int x2 = 0, y2 = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3195 _tcSol = new Solution3195();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,0],[1,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0}, new int[]{1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0],[0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumArea(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}