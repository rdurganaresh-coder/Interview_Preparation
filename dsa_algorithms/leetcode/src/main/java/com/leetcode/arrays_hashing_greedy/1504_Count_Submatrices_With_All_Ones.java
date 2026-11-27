package com.leetcode.arrays_hashing_greedy;

class Solution1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] g = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) {
                    g[i][j] = j == 0 ? 1 : 1 + g[i][j - 1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int col = 1 << 30;
                for (int k = i; k >= 0 && col > 0; --k) {
                    col = Math.min(col, g[k][j]);
                    ans += col;
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
        Solution1504 _tcSol = new Solution1504();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,0,1],[1,1,0],[1,1,0]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 0, 1}, new int[]{1, 1, 0}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmat(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 1}, new int[]{1, 1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmat(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();
    }
}