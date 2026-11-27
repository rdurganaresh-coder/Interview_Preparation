package com.leetcode.dynamic_programming;

class Solution0861 {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int cnt = 0;
            for (int i = 0; i < m; ++i) {
                cnt += grid[i][j];
            }
            ans += Math.max(cnt, m - cnt) * (1 << (n - j - 1));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0861 _tcSol = new Solution0861();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 1, 1}, new int[]{1, 0, 1, 0}, new int[]{1, 1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "39");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0]]");
        try {
            int[][] grid = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}