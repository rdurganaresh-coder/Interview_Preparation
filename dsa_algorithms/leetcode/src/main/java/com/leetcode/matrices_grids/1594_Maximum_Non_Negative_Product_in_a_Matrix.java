package com.leetcode.matrices_grids;

class Solution1594 {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] f = new long[m][n][2];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                long x = grid[i][j];

                if (i == 0 && j == 0) {
                    f[i][j][0] = x;
                    f[i][j][1] = x;
                    continue;
                }

                long mn = Long.MAX_VALUE, mx = Long.MIN_VALUE;

                if (i > 0) {
                    long a = f[i - 1][j][0], b = f[i - 1][j][1];
                    mn = Math.min(mn, Math.min(a * x, b * x));
                    mx = Math.max(mx, Math.max(a * x, b * x));
                }

                if (j > 0) {
                    long a = f[i][j - 1][0], b = f[i][j - 1][1];
                    mn = Math.min(mn, Math.min(a * x, b * x));
                    mx = Math.max(mx, Math.max(a * x, b * x));
                }

                f[i][j][0] = mn;
                f[i][j][1] = mx;
            }
        }

        long ans = f[m - 1][n - 1][1];
        int mod = (int) 1e9 + 7;
        return ans < 0 ? -1 : (int) (ans % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1594 _tcSol = new Solution1594();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]");
        try {
            int[][] grid = new int[][]{new int[]{-1, -2, -3}, new int[]{-2, -3, -3}, new int[]{-3, -3, -2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProductPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,-2,1],[1,-2,1],[3,-4,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, -2, 1}, new int[]{1, -2, 1}, new int[]{3, -4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProductPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,3],[0,-4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 3}, new int[]{0, -4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProductPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
