package com.leetcode.matrices_grids;

class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] s = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + mat[i][j];
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = Math.max(i - k, 0);
                int y1 = Math.max(j - k, 0);
                int x2 = Math.min(m - 1, i + k);
                int y2 = Math.min(n - 1, j + k);
                ans[i][j] = s[x2 + 1][y2 + 1] - s[x1][y2 + 1] - s[x2 + 1][y1] + s[x1][y1];
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
        Solution1314 _tcSol = new Solution1314();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixBlockSum(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[12,21,16],[27,45,33],[24,39,28]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixBlockSum(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[45,45,45],[45,45,45],[45,45,45]]");
        System.out.println();
    }
}