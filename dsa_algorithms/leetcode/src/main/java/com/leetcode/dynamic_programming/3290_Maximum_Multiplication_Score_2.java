package com.leetcode.dynamic_programming;

class Solution3290_2 {
    public long maxScore(int[] a, int[] b) {
        int m = a.length, n = b.length;
        long[][] f = new long[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            f[i][n] = Long.MIN_VALUE / 2;
        }
        for (int j = n - 1; j >= 0; --j) {
            for (int i = m - 1; i >= 0; --i) {
                f[i][j] = Math.max(f[i][j + 1], 1L * a[i] * b[j] + f[i + 1][j + 1]);
            }
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3290_2 _tcSol = new Solution3290_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]");
        try {
            int[] a = new int[]{3, 2, 5, 6};
            int[] b = new int[]{2, -6, 4, -5, -3, 2, -7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "26");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = [-1,4,5,-2], b = [-5,-1,-3,-2,-4]");
        try {
            int[] a = new int[]{-1, 4, 5, -2};
            int[] b = new int[]{-5, -1, -3, -2, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
