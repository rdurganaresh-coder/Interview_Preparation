package com.leetcode.matrices_grids;

class Solution0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0074 _tcSol = new Solution0074();
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