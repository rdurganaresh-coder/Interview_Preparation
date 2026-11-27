package com.leetcode.arrays_hashing_greedy;

class Solution0688 {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] f = new double[k + 1][n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[0][i][j] = 1;
            }
        }
        int[] dirs = {-2, -1, 2, 1, -2, 1, 2, -1, -2};
        for (int h = 1; h <= k; ++h) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int p = 0; p < 8; ++p) {
                        int x = i + dirs[p], y = j + dirs[p + 1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            f[h][i][j] += f[h - 1][x][y] / 8;
                        }
                    }
                }
            }
        }
        return f[k][row][column];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0688 _tcSol = new Solution0688();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 2, row = 0, column = 0");
        try {
            int n = 3;
            int k = 2;
            int row = 0;
            int column = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.knightProbability(n, k, row, column)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.06250");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, k = 0, row = 0, column = 0");
        try {
            int n = 1;
            int k = 0;
            int row = 0;
            int column = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.knightProbability(n, k, row, column)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();
    }
}