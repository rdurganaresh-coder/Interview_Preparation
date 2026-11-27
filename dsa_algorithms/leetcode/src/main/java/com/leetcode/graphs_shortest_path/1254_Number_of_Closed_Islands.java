package com.leetcode.graphs_shortest_path;

class Solution1254 {
    private int m;
    private int n;
    private int[][] grid;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans += dfs(i, j);
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        int res = i > 0 && i < m - 1 && j > 0 && j < n - 1 ? 1 : 0;
        grid[i][j] = 1;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                res &= dfs(x, y);
            }
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1254 _tcSol = new Solution1254();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0, 1, 1, 0}, new int[]{1, 0, 1, 0, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0, 1, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.closedIsland(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 1, 0, 0}, new int[]{0, 1, 0, 1, 0}, new int[]{0, 1, 1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.closedIsland(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1,1,1,1,1],[1,0,0,0,0,0,1],[1,0,1,1,1,0,1],[1,0,1,0,1,0,1],[1,0,1,1,1,0,1],[1,0,0,0,0,0,1],[1,1,1,1,1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 0, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.closedIsland(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}