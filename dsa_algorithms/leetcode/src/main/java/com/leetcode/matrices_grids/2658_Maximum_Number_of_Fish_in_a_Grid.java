package com.leetcode.matrices_grids;

class Solution2658 {
    private int[][] grid;
    private int m;
    private int n;

    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        int cnt = grid[i][j];
        grid[i][j] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
                cnt += dfs(x, y);
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2658 _tcSol = new Solution2658();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 2, 1, 0}, new int[]{4, 0, 0, 3}, new int[]{1, 0, 0, 4}, new int[]{0, 3, 2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxFish(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxFish(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}