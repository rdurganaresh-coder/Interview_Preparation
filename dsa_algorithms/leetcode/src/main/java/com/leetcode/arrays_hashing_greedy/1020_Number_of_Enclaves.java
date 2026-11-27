package com.leetcode.arrays_hashing_greedy;

class Solution1020 {
    private int[][] grid;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            for (int i : List.of(0, m - 1)) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j : List.of(0, n - 1)) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }
        int ans = 0;
        for (var row : grid) {
            for (int x : row) {
                ans += x;
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        grid[i][j] = 0;
        final int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1020 _tcSol = new Solution1020();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0, 0}, new int[]{1, 0, 1, 0}, new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numEnclaves(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numEnclaves(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
