package com.leetcode.graphs_shortest_path;

class Solution2556 {
    private int[][] grid;
    private int m;
    private int n;

    public boolean isPossibleToCutPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        boolean a = dfs(0, 0);
        grid[0][0] = 1;
        grid[m - 1][n - 1] = 1;
        boolean b = dfs(0, 0);
        return !(a && b);
    }

    private boolean dfs(int i, int j) {
        if (i >= m || j >= n || grid[i][j] == 0) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        grid[i][j] = 0;
        return dfs(i + 1, j) || dfs(i, j + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2556 _tcSol = new Solution2556();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,0,0],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 0}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToCutPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,0,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToCutPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
