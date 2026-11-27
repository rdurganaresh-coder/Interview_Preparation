package com.leetcode.matrices_grids;

class Solution2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i % 2 == 1 && mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
                if (i % 2 == 0 && mat[i][j] != mat[i][(j - k + n) % n]) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2946 _tcSol = new Solution2946();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.areSimilar(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 1, 2}, new int[]{5, 5, 5, 5}, new int[]{6, 3, 6, 3}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.areSimilar(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[2,2],[2,2]], k = 3");
        try {
            int[][] mat = new int[][]{new int[]{2, 2}, new int[]{2, 2}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.areSimilar(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}