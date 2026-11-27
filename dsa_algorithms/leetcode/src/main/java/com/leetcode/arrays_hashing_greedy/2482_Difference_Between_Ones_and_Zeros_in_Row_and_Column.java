package com.leetcode.arrays_hashing_greedy;

class Solution2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = grid[i][j];
                rows[i] += v;
                cols[j] += v;
            }
        }
        int[][] diff = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                diff[i][j] = rows[i] + cols[j] - (n - rows[i]) - (m - cols[j]);
            }
        }
        return diff;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2482 _tcSol = new Solution2482();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,1],[1,0,1],[0,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1}, new int[]{1, 0, 1}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.onesMinusZeros(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,4],[0,0,4],[-2,-2,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.onesMinusZeros(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5,5,5],[5,5,5]]");
        System.out.println();
    }
}