package com.leetcode.bit_manipulation_math;

class Solution1292 {
    private int m;
    private int n;
    private int threshold;
    private int[][] s;

    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        this.threshold = threshold;
        s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int l = 0, r = Math.min(m, n);
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k) {
        for (int i = 0; i < m - k + 1; ++i) {
            for (int j = 0; j < n - k + 1; ++j) {
                if (s[i + k][j + k] - s[i][j + k] - s[i + k][j] + s[i][j] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1292 _tcSol = new Solution1292();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4");
        try {
            int[][] mat = new int[][]{new int[]{1, 1, 3, 2, 4, 3, 2}, new int[]{1, 1, 3, 2, 4, 3, 2}, new int[]{1, 1, 3, 2, 4, 3, 2}};
            int threshold = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSideLength(mat, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1");
        try {
            int[][] mat = new int[][]{new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2}};
            int threshold = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSideLength(mat, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}