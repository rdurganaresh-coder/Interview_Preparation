package com.leetcode.arrays_hashing_greedy;

class Solution2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (var q : queries) {
            int x1 = q[0], y1 = q[1], x2 = q[2], y2 = q[3];
            mat[x1][y1]++;
            if (x2 + 1 < n) {
                mat[x2 + 1][y1]--;
            }
            if (y2 + 1 < n) {
                mat[x1][y2 + 1]--;
            }
            if (x2 + 1 < n && y2 + 1 < n) {
                mat[x2 + 1][y2 + 1]++;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    mat[i][j] += mat[i - 1][j];
                }
                if (j > 0) {
                    mat[i][j] += mat[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    mat[i][j] -= mat[i - 1][j - 1];
                }
            }
        }
        return mat;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2536 _tcSol = new Solution2536();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, queries = [[1,1,2,2],[0,0,1,1]]");
        try {
            int n = 3;
            int[][] queries = new int[][]{new int[]{1, 1, 2, 2}, new int[]{0, 0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeAddQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,0],[1,2,1],[0,1,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, queries = [[0,0,1,1]]");
        try {
            int n = 2;
            int[][] queries = new int[][]{new int[]{0, 0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeAddQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1],[1,1]]");
        System.out.println();
    }
}