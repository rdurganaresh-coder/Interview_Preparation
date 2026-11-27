package com.leetcode.graphs_shortest_path;

class Solution1219 {
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private int[][] grid;
    private int m;
    private int n;

    public int getMaximumGold(int[][] grid) {
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
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        int v = grid[i][j];
        grid[i][j] = 0;
        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            ans = Math.max(ans, v + dfs(i + dirs[k], j + dirs[k + 1]));
        }
        grid[i][j] = v;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1219 _tcSol = new Solution1219();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,6,0],[5,8,7],[0,9,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 6, 0}, new int[]{5, 8, 7}, new int[]{0, 9, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumGold(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 7}, new int[]{2, 0, 6}, new int[]{3, 4, 5}, new int[]{0, 3, 0}, new int[]{9, 0, 20}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumGold(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();
    }
}