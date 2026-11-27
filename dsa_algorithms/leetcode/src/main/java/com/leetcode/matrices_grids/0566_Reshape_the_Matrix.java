package com.leetcode.matrices_grids;

class Solution0566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0566 _tcSol = new Solution0566();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2],[3,4]], r = 1, c = 4");
        try {
            int[][] mat = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            int r = 1;
            int c = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixReshape(mat, r, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,3,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,2],[3,4]], r = 2, c = 4");
        try {
            int[][] mat = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            int r = 2;
            int c = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixReshape(mat, r, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[3,4]]");
        System.out.println();
    }
}