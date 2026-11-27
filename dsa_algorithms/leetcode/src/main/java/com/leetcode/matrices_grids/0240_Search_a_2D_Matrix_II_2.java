package com.leetcode.matrices_grids;

class Solution0240_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                --i;
            } else {
                ++j;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0240_2 _tcSol = new Solution0240_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5");
        try {
            int[][] matrix = new int[][]{new int[]{1, 4, 7, 11, 15}, new int[]{2, 5, 8, 12, 19}, new int[]{3, 6, 9, 16, 22}, new int[]{10, 13, 14, 17, 24}, new int[]{18, 21, 23, 26, 30}};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchMatrix(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20");
        try {
            int[][] matrix = new int[][]{new int[]{1, 4, 7, 11, 15}, new int[]{2, 5, 8, 12, 19}, new int[]{3, 6, 9, 16, 22}, new int[]{10, 13, 14, 17, 24}, new int[]{18, 21, 23, 26, 30}};
            int target = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchMatrix(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}