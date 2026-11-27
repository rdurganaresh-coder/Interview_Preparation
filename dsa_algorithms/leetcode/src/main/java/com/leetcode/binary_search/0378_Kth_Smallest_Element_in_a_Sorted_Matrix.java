package com.leetcode.binary_search;

class Solution0378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int count = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += (i + 1);
                ++j;
            } else {
                --i;
            }
        }
        return count >= k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0378 _tcSol = new Solution0378();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8");
        try {
            int[][] matrix = new int[][]{new int[]{1, 5, 9}, new int[]{10, 11, 13}, new int[]{12, 13, 15}};
            int k = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[-5]], k = 1");
        try {
            int[][] matrix = new int[][]{new int[]{-5}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-5");
        System.out.println();
    }
}