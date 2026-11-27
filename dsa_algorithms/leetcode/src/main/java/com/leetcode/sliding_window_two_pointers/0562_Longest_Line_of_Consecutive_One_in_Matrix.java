package com.leetcode.sliding_window_two_pointers;

class Solution0562 {
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] a = new int[m + 2][n + 2];
        int[][] b = new int[m + 2][n + 2];
        int[][] c = new int[m + 2][n + 2];
        int[][] d = new int[m + 2][n + 2];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (mat[i - 1][j - 1] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                    c[i][j] = c[i - 1][j - 1] + 1;
                    d[i][j] = d[i - 1][j + 1] + 1;
                    ans = max(ans, a[i][j], b[i][j], c[i][j], d[i][j]);
                }
            }
        }
        return ans;
    }

    private int max(int... arr) {
        int ans = 0;
        for (int v : arr) {
            ans = Math.max(ans, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0562 _tcSol = new Solution0562();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestLine(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 1, 1, 1}, new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestLine(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}