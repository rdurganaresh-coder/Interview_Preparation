package com.leetcode.matrices_grids;

class Solution0867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ans[i][j] = matrix[j][i];
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
        Solution0867 _tcSol = new Solution0867();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.transpose(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,4,7],[2,5,8],[3,6,9]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,2,3],[4,5,6]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.transpose(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,4],[2,5],[3,6]]");
        System.out.println();
    }
}