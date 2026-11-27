package com.leetcode.arrays_hashing_greedy;

class Solution0799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] f = new double[101][101];
        f[0][0] = poured;
        for (int i = 0; i <= query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (f[i][j] > 1) {
                    double half = (f[i][j] - 1) / 2.0;
                    f[i][j] = 1;
                    f[i + 1][j] += half;
                    f[i + 1][j + 1] += half;
                }
            }
        }
        return f[query_row][query_glass];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0799 _tcSol = new Solution0799();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "poured = 1, query_row = 1, query_glass = 1");
        try {
            int poured = 1;
            int query_row = 1;
            int query_glass = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.champagneTower(poured, query_row, query_glass)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "poured = 2, query_row = 1, query_glass = 1");
        try {
            int poured = 2;
            int query_row = 1;
            int query_glass = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.champagneTower(poured, query_row, query_glass)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.50000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "poured = 100000009, query_row = 33, query_glass = 17");
        try {
            int poured = 100000009;
            int query_row = 33;
            int query_glass = 17;
            System.out.println("  Output  : " + _tcShow(_tcSol.champagneTower(poured, query_row, query_glass)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();
    }
}