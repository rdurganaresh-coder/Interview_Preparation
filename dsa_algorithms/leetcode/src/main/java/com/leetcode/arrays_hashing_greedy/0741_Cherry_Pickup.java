package com.leetcode.arrays_hashing_greedy;

class Solution0741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n * 2][n][n];
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int i1 = 0; i1 < n; ++i1) {
                for (int i2 = 0; i2 < n; ++i2) {
                    int j1 = k - i1, j2 = k - i2;
                    f[k][i1][i2] = Integer.MIN_VALUE;
                    if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n || grid[i1][j1] == -1
                        || grid[i2][j2] == -1) {
                        continue;
                    }
                    int t = grid[i1][j1];
                    if (i1 != i2) {
                        t += grid[i2][j2];
                    }
                    for (int x1 = i1 - 1; x1 <= i1; ++x1) {
                        for (int x2 = i2 - 1; x2 <= i2; ++x2) {
                            if (x1 >= 0 && x2 >= 0) {
                                f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][x1][x2] + t);
                            }
                        }
                    }
                }
            }
        }
        return Math.max(0, f[n * 2 - 2][n - 1][n - 1]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0741 _tcSol = new Solution0741();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,-1],[1,0,-1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, -1}, new int[]{1, 0, -1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.cherryPickup(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,-1],[1,-1,1],[-1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, -1}, new int[]{1, -1, 1}, new int[]{-1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.cherryPickup(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}