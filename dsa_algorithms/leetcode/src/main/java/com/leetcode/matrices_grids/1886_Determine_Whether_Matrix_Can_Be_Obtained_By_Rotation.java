package com.leetcode.matrices_grids;

class Solution1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int ok = 0b1111;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    ok &= ~0b0001;
                }
                if (mat[j][n - 1 - i] != target[i][j]) {
                    ok &= ~0b0010;
                }
                if (mat[n - 1 - i][n - 1 - j] != target[i][j]) {
                    ok &= ~0b0100;
                }
                if (mat[n - 1 - j][i] != target[i][j]) {
                    ok &= ~0b1000;
                }
                if (ok == 0) {
                    return false;
                }
            }
        }
        return ok != 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1886 _tcSol = new Solution1886();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[0,1],[1,0]], target = [[1,0],[0,1]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            int[][] target = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRotation(mat, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[0,1],[1,1]], target = [[1,0],[0,1]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 1}, new int[]{1, 1}};
            int[][] target = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRotation(mat, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 1}};
            int[][] target = new int[][]{new int[]{1, 1, 1}, new int[]{0, 1, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRotation(mat, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
