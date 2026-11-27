package com.leetcode.matrices_grids;

class Solution1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] g = new int[m][n];
        for (int[] e : indices) {
            int r = e[0], c = e[1];
            for (int i = 0; i < m; ++i) {
                g[i][c]++;
            }
            for (int j = 0; j < n; ++j) {
                g[r][j]++;
            }
        }
        int ans = 0;
        for (int[] row : g) {
            for (int v : row) {
                ans += v % 2;
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
        Solution1252 _tcSol = new Solution1252();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 2, n = 3, indices = [[0,1],[1,1]]");
        try {
            int m = 2;
            int n = 3;
            int[][] indices = new int[][]{new int[]{0, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddCells(m, n, indices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 2, n = 2, indices = [[1,1],[0,0]]");
        try {
            int m = 2;
            int n = 2;
            int[][] indices = new int[][]{new int[]{1, 1}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddCells(m, n, indices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}