package com.leetcode.graphs_shortest_path;

class Solution2510 {
    private int s;
    private int m;
    private int n;
    private int[][] grid;
    private Boolean[][][] f;

    public boolean isThereAPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        s = m + n - 1;
        f = new Boolean[m][n][s];
        if (s % 2 == 1) {
            return false;
        }
        s >>= 1;
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        if (i >= m || j >= n) {
            return false;
        }
        k += grid[i][j];
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        if (k > s || i + j + 1 - k > s) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return k == s;
        }
        f[i][j][k] = dfs(i + 1, j, k) || dfs(i, j + 1, k);
        return f[i][j][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2510 _tcSol = new Solution2510();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,0,0],[0,1,0,0],[1,0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0, 0}, new int[]{0, 1, 0, 0}, new int[]{1, 0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isThereAPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,0],[0,0,1],[1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isThereAPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}