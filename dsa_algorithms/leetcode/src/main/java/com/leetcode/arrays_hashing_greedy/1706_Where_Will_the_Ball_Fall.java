package com.leetcode.arrays_hashing_greedy;

class Solution1706 {
    private int m;
    private int n;
    private int[][] grid;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int[] ans = new int[n];
        for (int j = 0; j < n; ++j) {
            ans[j] = dfs(0, j);
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (i == m) {
            return j;
        }
        if (j == 0 && grid[i][j] == -1) {
            return -1;
        }
        if (j == n - 1 && grid[i][j] == 1) {
            return -1;
        }
        if (grid[i][j] == 1 && grid[i][j + 1] == -1) {
            return -1;
        }
        if (grid[i][j] == -1 && grid[i][j - 1] == 1) {
            return -1;
        }
        return grid[i][j] == 1 ? dfs(i + 1, j + 1) : dfs(i + 1, j - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1706 _tcSol = new Solution1706();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, -1, -1}, new int[]{1, 1, 1, -1, -1}, new int[]{-1, -1, -1, 1, 1}, new int[]{1, 1, 1, 1, -1}, new int[]{-1, -1, -1, -1, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findBall(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,-1,-1,-1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[-1]]");
        try {
            int[][] grid = new int[][]{new int[]{-1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findBall(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1, 1, 1}, new int[]{-1, -1, -1, -1, -1, -1}, new int[]{1, 1, 1, 1, 1, 1}, new int[]{-1, -1, -1, -1, -1, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findBall(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,4,-1]");
        System.out.println();
    }
}