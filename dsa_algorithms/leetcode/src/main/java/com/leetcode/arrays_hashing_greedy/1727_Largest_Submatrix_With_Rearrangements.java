package com.leetcode.arrays_hashing_greedy;

class Solution1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (var row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
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
        Solution1727 _tcSol = new Solution1727();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[0,0,1],[1,1,1],[1,0,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSubmatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,0,1,0,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 0, 1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSubmatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[1,1,0],[1,0,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 1, 0}, new int[]{1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSubmatrix(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}