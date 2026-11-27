package com.leetcode.arrays_hashing_greedy;

class Solution2088 {
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        int ans = 0;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    f[i][j] = -1;
                } else if (i == m - 1 || j == 0 || j == n - 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i + 1][j - 1], Math.min(f[i + 1][j], f[i + 1][j + 1])) + 1;
                    ans += f[i][j];
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    f[i][j] = -1;
                } else if (i == 0 || j == 0 || j == n - 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i - 1][j + 1])) + 1;
                    ans += f[i][j];
                }
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
        Solution2088 _tcSol = new Solution2088();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,1,0],[1,1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1, 0}, new int[]{1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPyramids(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPyramids(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1,1,0],[1,1,1,1,1],[1,1,1,1,1],[0,1,0,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 1, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPyramids(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}