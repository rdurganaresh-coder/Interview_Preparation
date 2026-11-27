package com.leetcode.matrices_grids;

class Solution1975 {
    public long maxMatrixSum(int[][] matrix) {
        long s = 0;
        int mi = 1 << 30, cnt = 0;
        for (var row : matrix) {
            for (int x : row) {
                cnt += x < 0 ? 1 : 0;
                int y = Math.abs(x);
                mi = Math.min(mi, y);
                s += y;
            }
        }
        return cnt % 2 == 0 ? s : s - mi * 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1975 _tcSol = new Solution1975();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,-1],[-1,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, -1}, new int[]{-1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMatrixSum(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{1, 2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMatrixSum(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
