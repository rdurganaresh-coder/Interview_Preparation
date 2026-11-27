package com.leetcode.matrices_grids;

class Solution0766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0766 _tcSol = new Solution0766();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 1, 2, 3}, new int[]{9, 5, 1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isToeplitzMatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,2],[2,2]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isToeplitzMatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}