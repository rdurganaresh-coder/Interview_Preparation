package com.leetcode.bit_manipulation_math;

class Solution0221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int mx = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    mx = Math.max(mx, dp[i + 1][j + 1]);
                }
            }
        }
        return mx * mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0221 _tcSol = new Solution0221();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
        try {
            char[][] matrix = new char[][]{new char[]{'1', '0', '1', '0', '0'}, new char[]{'1', '0', '1', '1', '1'}, new char[]{'1', '1', '1', '1', '1'}, new char[]{'1', '0', '0', '1', '0'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalSquare(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[\"0\",\"1\"],[\"1\",\"0\"]]");
        try {
            char[][] matrix = new char[][]{new char[]{'0', '1'}, new char[]{'1', '0'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalSquare(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[\"0\"]]");
        try {
            char[][] matrix = new char[][]{new char[]{'0'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximalSquare(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}