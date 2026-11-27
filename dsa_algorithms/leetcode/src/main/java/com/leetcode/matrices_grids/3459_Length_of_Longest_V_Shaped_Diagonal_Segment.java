package com.leetcode.matrices_grids;

class Solution3459 {
    private int m, n;
    private final int[] dirs = {1, 1, -1, -1, 1};
    private Integer[][][][] f;

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        f = new Integer[m][n][4][2];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        ans = Math.max(ans, dfs(grid, i, j, k, 1) + 1);
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int k, int cnt) {
        if (f[i][j][k][cnt] != null) {
            return f[i][j][k][cnt];
        }
        int x = i + dirs[k];
        int y = j + dirs[k + 1];
        int target = grid[i][j] == 1 ? 2 : (2 - grid[i][j]);
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != target) {
            f[i][j][k][cnt] = 0;
            return 0;
        }
        int res = dfs(grid, x, y, k, cnt);
        if (cnt > 0) {
            res = Math.max(res, dfs(grid, x, y, (k + 1) % 4, 0));
        }
        f[i][j][k][cnt] = 1 + res;
        return 1 + res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3459 _tcSol = new Solution3459();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 2, 1, 2, 2}, new int[]{2, 0, 2, 2, 0}, new int[]{2, 0, 1, 1, 0}, new int[]{1, 0, 2, 2, 2}, new int[]{2, 0, 0, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lenOfVDiagonal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 2, 2, 2, 2}, new int[]{2, 0, 2, 2, 0}, new int[]{2, 0, 1, 1, 0}, new int[]{1, 0, 2, 2, 2}, new int[]{2, 0, 0, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lenOfVDiagonal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 0}, new int[]{2, 0, 0, 0, 0}, new int[]{0, 0, 2, 2, 2}, new int[]{2, 0, 0, 2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lenOfVDiagonal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "grid = [[1]]");
        try {
            int[][] grid = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.lenOfVDiagonal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
