package com.leetcode.dynamic_programming;

class Solution1039_3 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int l = 3; l <= n; ++l) {
            for (int i = 0; i + l - 1 < n; ++i) {
                int j = i + l - 1;
                f[i][j] = 1 << 30;
                for (int k = i + 1; k < j; ++k) {
                    f[i][j]
                        = Math.min(f[i][j], f[i][k] + f[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return f[0][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1039_3 _tcSol = new Solution1039_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "values = [1,2,3]");
        try {
            int[] values = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScoreTriangulation(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "values = [3,7,4,5]");
        try {
            int[] values = new int[]{3, 7, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScoreTriangulation(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "144");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "values = [1,3,1,4,1,5]");
        try {
            int[] values = new int[]{1, 3, 1, 4, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minScoreTriangulation(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}