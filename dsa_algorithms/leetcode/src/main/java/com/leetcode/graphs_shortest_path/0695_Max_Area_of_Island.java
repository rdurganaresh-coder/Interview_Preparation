package com.leetcode.graphs_shortest_path;

class Solution0695 {
    private int m;
    private int n;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int ans = 1;
        grid[i][j] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                ans += dfs(x, y);
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
        Solution0695 _tcSol = new Solution0695();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAreaOfIsland(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,0,0,0,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0, 0, 0, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAreaOfIsland(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}