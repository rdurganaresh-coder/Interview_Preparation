package com.leetcode.matrices_grids;

class Solution0073 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0073 _tcSol = new Solution0073();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,1,1],[1,0,1],[1,1,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
            _tcSol.setZeroes(matrix);
            System.out.println("  Output  : " + _tcShow(matrix));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,0,1],[0,0,0],[1,0,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        try {
            int[][] matrix = new int[][]{new int[]{0, 1, 2, 0}, new int[]{3, 4, 5, 2}, new int[]{1, 3, 1, 5}};
            _tcSol.setZeroes(matrix);
            System.out.println("  Output  : " + _tcShow(matrix));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]");
        System.out.println();
    }
}
