package com.leetcode.graphs_shortest_path;

class Solution2435 {
    public int numberOfPaths(int[][] grid, int K) {
        final int mod = (int) 1e9 + 7;
        int m = grid.length, n = grid[0].length;
        int[][][] f = new int[m][n][K];
        f[0][0][grid[0][0] % K] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < K; ++k) {
                    int k0 = ((k - grid[i][j] % K) + K) % K;
                    if (i > 0) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][k0]) % mod;
                    }
                    if (j > 0) {
                        f[i][j][k] = (f[i][j][k] + f[i][j - 1][k0]) % mod;
                    }
                }
            }
        }
        return f[m - 1][n - 1][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2435 _tcSol = new Solution2435();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3");
        try {
            int[][] grid = new int[][]{new int[]{5, 2, 4}, new int[]{3, 0, 5}, new int[]{0, 7, 2}};
            int K = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPaths(grid, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0]], k = 5");
        try {
            int[][] grid = new int[][]{new int[]{0, 0}};
            int K = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPaths(grid, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1");
        try {
            int[][] grid = new int[][]{new int[]{7, 3, 4, 9}, new int[]{2, 3, 6, 2}, new int[]{2, 3, 7, 0}};
            int K = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPaths(grid, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
