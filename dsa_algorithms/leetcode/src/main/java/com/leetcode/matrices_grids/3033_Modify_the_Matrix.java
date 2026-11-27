package com.leetcode.matrices_grids;

class Solution3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; ++j) {
            int mx = -1;
            for (int i = 0; i < m; ++i) {
                mx = Math.max(mx, matrix[i][j]);
            }
            for (int i = 0; i < m; ++i) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = mx;
                }
            }
        }
        return matrix;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3033 _tcSol = new Solution3033();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2,-1],[4,-1,6],[7,8,9]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, -1}, new int[]{4, -1, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.modifiedMatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,9],[4,8,6],[7,8,9]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[3,-1],[5,2]]");
        try {
            int[][] matrix = new int[][]{new int[]{3, -1}, new int[]{5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.modifiedMatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,2],[5,2]]");
        System.out.println();
    }
}