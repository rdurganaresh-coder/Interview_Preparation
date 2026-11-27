package com.leetcode.matrices_grids;

class Solution0311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat2[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < mat2.length; ++k) {
                    ans[i][j] += mat1[i][k] * mat2[k][j];
                }
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
        Solution0311 _tcSol = new Solution0311();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]");
        try {
            int[][] mat1 = new int[][]{new int[]{1, 0, 0}, new int[]{-1, 0, 3}};
            int[][] mat2 = new int[][]{new int[]{7, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(mat1, mat2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[7,0,0],[-7,0,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat1 = [[0]], mat2 = [[0]]");
        try {
            int[][] mat1 = new int[][]{new int[]{0}};
            int[][] mat2 = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(mat1, mat2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0]]");
        System.out.println();
    }
}