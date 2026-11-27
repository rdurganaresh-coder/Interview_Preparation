package com.leetcode.matrices_grids;

class Solution0048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n >> 1; ++i) {
            for (int j = 0; j < n; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = t;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0048 _tcSol = new Solution0048();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            _tcSol.rotate(matrix);
            System.out.println("  Output  : " + _tcShow(matrix));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[7,4,1],[8,5,2],[9,6,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        try {
            int[][] matrix = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
            _tcSol.rotate(matrix);
            System.out.println("  Output  : " + _tcShow(matrix));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
        System.out.println();
    }
}