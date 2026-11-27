package com.leetcode.arrays_hashing_greedy;

class Solution3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ans += (rows[i] - 1) * (cols[j] - 1);
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3128 _tcSol = new Solution3128();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,0],[0,1,1],[0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0}, new int[]{0, 1, 1}, new int[]{0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfRightTriangles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0}, new int[]{0, 1, 0, 1}, new int[]{1, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfRightTriangles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,0,1],[1,0,0],[1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 1}, new int[]{1, 0, 0}, new int[]{1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfRightTriangles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}