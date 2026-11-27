package com.leetcode.graphs_shortest_path;

class Solution1905 {
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private int[][] grid1;
    private int[][] grid2;
    private int m;
    private int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        this.grid1 = grid1;
        this.grid2 = grid2;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1) {
                    ans += dfs(i, j);
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        int ok = grid1[i][j];
        grid2[i][j] = 0;
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                ok &= dfs(x, y);
            }
        }
        return ok;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1905 _tcSol = new Solution1905();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]");
        try {
            int[][] grid1 = new int[][]{new int[]{1, 1, 1, 0, 0}, new int[]{0, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 0, 1, 1}};
            int[][] grid2 = new int[][]{new int[]{1, 1, 1, 0, 0}, new int[]{0, 0, 1, 1, 1}, new int[]{0, 1, 0, 0, 0}, new int[]{1, 0, 1, 1, 0}, new int[]{0, 1, 0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubIslands(grid1, grid2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]");
        try {
            int[][] grid1 = new int[][]{new int[]{1, 0, 1, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}};
            int[][] grid2 = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 1, 0, 1, 0}, new int[]{0, 1, 0, 1, 0}, new int[]{1, 0, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubIslands(grid1, grid2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
