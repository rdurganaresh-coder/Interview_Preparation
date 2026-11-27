package com.leetcode.arrays_hashing_greedy;

class Solution3122 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[n][10];
        final int inf = 1 << 29;
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[10];
            for (int j = 0; j < m; ++j) {
                ++cnt[grid[j][i]];
            }
            if (i == 0) {
                for (int j = 0; j < 10; ++j) {
                    f[i][j] = m - cnt[j];
                }
            } else {
                for (int j = 0; j < 10; ++j) {
                    for (int k = 0; k < 10; ++k) {
                        if (k != j) {
                            f[i][j] = Math.min(f[i][j], f[i - 1][k] + m - cnt[j]);
                        }
                    }
                }
            }
        }
        int ans = inf;
        for (int j = 0; j < 10; ++j) {
            ans = Math.min(ans, f[n - 1][j]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3122 _tcSol = new Solution3122();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,2],[1,0,2]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 2}, new int[]{1, 0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1],[2],[3]]");
        try {
            int[][] grid = new int[][]{new int[]{1}, new int[]{2}, new int[]{3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}