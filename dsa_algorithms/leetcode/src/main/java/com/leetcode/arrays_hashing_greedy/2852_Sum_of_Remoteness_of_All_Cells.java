package com.leetcode.arrays_hashing_greedy;

class Solution2852 {
    private int n;
    private int[][] grid;
    private final int[] dirs = {-1, 0, 1, 0, -1};

    public long sumRemoteness(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        int cnt = 0;
        for (int[] row : grid) {
            for (int x : row) {
                if (x > 0) {
                    ++cnt;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    long[] res = dfs(i, j);
                    ans += (cnt - res[1]) * res[0];
                }
            }
        }
        return ans;
    }

    private long[] dfs(int i, int j) {
        long[] res = new long[2];
        res[0] = grid[i][j];
        res[1] = 1;
        grid[i][j] = 0;
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 0) {
                long[] tmp = dfs(x, y);
                res[0] += tmp[0];
                res[1] += tmp[1];
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
        Solution2852 _tcSol = new Solution2852();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[-1,1,-1],[5,-1,4],[-1,3,-1]]");
        try {
            int[][] grid = new int[][]{new int[]{-1, 1, -1}, new int[]{5, -1, 4}, new int[]{-1, 3, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumRemoteness(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "39");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[-1,3,4],[-1,-1,-1],[3,-1,-1]]");
        try {
            int[][] grid = new int[][]{new int[]{-1, 3, 4}, new int[]{-1, -1, -1}, new int[]{3, -1, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumRemoteness(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1]]");
        try {
            int[][] grid = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumRemoteness(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}