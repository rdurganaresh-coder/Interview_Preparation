package com.leetcode.matrices_grids;

class Solution1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = x;
                rowSum[i] -= x;
                colSum[j] -= x;
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
        Solution1605 _tcSol = new Solution1605();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rowSum = [3,8], colSum = [4,7]");
        try {
            int[] rowSum = new int[]{3, 8};
            int[] colSum = new int[]{4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreMatrix(rowSum, colSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,0], [1,7]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rowSum = [5,7,10], colSum = [8,6,8]");
        try {
            int[] rowSum = new int[]{5, 7, 10};
            int[] colSum = new int[]{8, 6, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreMatrix(rowSum, colSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,5,0], [6,1,0], [2,0,8]]");
        System.out.println();
    }
}