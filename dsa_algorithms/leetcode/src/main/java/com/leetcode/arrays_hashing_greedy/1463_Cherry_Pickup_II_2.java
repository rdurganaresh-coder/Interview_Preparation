package com.leetcode.arrays_hashing_greedy;

class Solution1463_2 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[n][n];
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], -1);
            Arrays.fill(g[i], -1);
        }
        f[0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; ++i) {
            for (int j1 = 0; j1 < n; ++j1) {
                for (int j2 = 0; j2 < n; ++j2) {
                    int x = grid[i][j1] + (j1 == j2 ? 0 : grid[i][j2]);
                    for (int y1 = j1 - 1; y1 <= j1 + 1; ++y1) {
                        for (int y2 = j2 - 1; y2 <= j2 + 1; ++y2) {
                            if (y1 >= 0 && y1 < n && y2 >= 0 && y2 < n && f[y1][y2] != -1) {
                                g[j1][j2] = Math.max(g[j1][j2], f[y1][y2] + x);
                            }
                        }
                    }
                }
            }
            int[][] t = f;
            f = g;
            g = t;
        }
        int ans = 0;
        for (int j1 = 0; j1 < n; ++j1) {
            for (int j2 = 0; j2 < n; ++j2) {
                ans = Math.max(ans, f[j1][j2]);
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
        Solution1463_2 _tcSol = new Solution1463_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 1, 1}, new int[]{2, 5, 1}, new int[]{1, 5, 5}, new int[]{2, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.cherryPickup(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{2, 0, 0, 0, 0, 3, 0}, new int[]{2, 0, 9, 0, 0, 0, 0}, new int[]{0, 3, 0, 5, 4, 0, 0}, new int[]{1, 0, 2, 3, 0, 0, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.cherryPickup(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();
    }
}