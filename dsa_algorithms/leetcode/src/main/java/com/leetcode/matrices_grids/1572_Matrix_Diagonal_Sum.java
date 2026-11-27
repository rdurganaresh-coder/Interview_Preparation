package com.leetcode.matrices_grids;

class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for (int i = 0; i < n; ++i) {
            int j = n - i - 1;
            ans += mat[i][i] + (i == j ? 0 : mat[i][j]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1572 _tcSol = new Solution1572();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2,3], [4,5,6], [7,8,9]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalSum(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,1,1,1], [1,1,1,1], [1,1,1,1], [1,1,1,1]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalSum(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[5]]");
        try {
            int[][] mat = new int[][]{new int[]{5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalSum(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}