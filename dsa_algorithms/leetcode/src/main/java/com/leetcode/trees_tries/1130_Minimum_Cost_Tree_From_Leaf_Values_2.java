package com.leetcode.trees_tries;

class Solution1130_2 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n][n];
        int[][] g = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            g[i][i] = arr[i];
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = Math.max(g[i][j - 1], arr[j]);
                f[i][j] = 1 << 30;
                for (int k = i; k < j; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + g[i][k] * g[k + 1][j]);
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
        Solution1130_2 _tcSol = new Solution1130_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [6,2,4]");
        try {
            int[] arr = new int[]{6, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.mctFromLeafValues(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [4,11]");
        try {
            int[] arr = new int[]{4, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.mctFromLeafValues(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "44");
        System.out.println();
    }
}