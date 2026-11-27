package com.leetcode.arrays_hashing_greedy;

class Solution1034 {
    private int[][] grid;
    private int color;
    private int m;
    private int n;
    private boolean[][] vis;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        this.color = color;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        dfs(row, col, grid[row][col]);
        return grid;
    }

    private void dfs(int i, int j, int c) {
        vis[i][j] = true;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!vis[x][y]) {
                    if (grid[x][y] == c) {
                        dfs(x, y, c);
                    } else {
                        grid[i][j] = color;
                    }
                }
            } else {
                grid[i][j] = color;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1034 _tcSol = new Solution1034();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1],[1,2]], row = 0, col = 0, color = 3");
        try {
            int[][] grid = new int[][]{new int[]{1, 1}, new int[]{1, 2}};
            int row = 0;
            int col = 0;
            int color = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.colorBorder(grid, row, col, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,3],[3,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 2}, new int[]{2, 3, 2}};
            int row = 0;
            int col = 1;
            int color = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.colorBorder(grid, row, col, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3,3],[2,3,3]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}};
            int row = 1;
            int col = 1;
            int color = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.colorBorder(grid, row, col, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2,2],[2,1,2],[2,2,2]]");
        System.out.println();
    }
}