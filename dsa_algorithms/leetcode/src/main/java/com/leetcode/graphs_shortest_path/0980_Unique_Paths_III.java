package com.leetcode.graphs_shortest_path;

class Solution0980 {
    private int m;
    private int n;
    private int cnt;
    private int[][] grid;
    private boolean[][] vis;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int x = 0, y = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ++cnt;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        vis = new boolean[m][n];
        vis[x][y] = true;
        return dfs(x, y, 0);
    }

    private int dfs(int i, int j, int k) {
        if (grid[i][j] == 2) {
            return k == cnt + 1 ? 1 : 0;
        }
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int h = 0; h < 4; ++h) {
            int x = i + dirs[h], y = j + dirs[h + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] != -1) {
                vis[x][y] = true;
                ans += dfs(x, y, k + 1);
                vis[x][y] = false;
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
        Solution0980 _tcSol = new Solution0980();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 2, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniquePathsIII(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniquePathsIII(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0,1],[2,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniquePathsIII(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}