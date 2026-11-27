package com.leetcode.bit_manipulation_math;

class Solution1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }
                ans += f[i][j];
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
        Solution1277 _tcSol = new Solution1277();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [ [0,1,1,1], [1,1,1,1], [0,1,1,1] ]");
        try {
            int[][] matrix = new int[][]{new int[]{0, 1, 1, 1}, new int[]{1, 1, 1, 1}, new int[]{0, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSquares(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [ [1,0,1], [1,1,0], [1,1,0] ]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 0, 1}, new int[]{1, 1, 0}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSquares(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}