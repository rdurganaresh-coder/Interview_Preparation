package com.leetcode.matrices_grids;

class Solution0074_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = m - 1, j = 0; i >= 0 && j < n;) {
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
        Solution0074_2 _tcSol = new Solution0074_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3");
        try {
            int[][] matrix = new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchMatrix(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13");
        try {
            int[][] matrix = new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}};
            int target = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchMatrix(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}