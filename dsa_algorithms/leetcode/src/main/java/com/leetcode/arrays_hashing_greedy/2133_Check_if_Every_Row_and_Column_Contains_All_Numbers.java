package com.leetcode.arrays_hashing_greedy;

class Solution2133 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[] vis = new boolean[n + 1];
        for (var row : matrix) {
            Arrays.fill(vis, false);
            for (int x : row) {
                if (vis[x]) {
                    return false;
                }
                vis[x] = true;
            }
        }
        for (int j = 0; j < n; ++j) {
            Arrays.fill(vis, false);
            for (int i = 0; i < n; ++i) {
                if (vis[matrix[i][j]]) {
                    return false;
                }
                vis[matrix[i][j]] = true;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2133 _tcSol = new Solution2133();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2,3],[3,1,2],[2,3,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{3, 1, 2}, new int[]{2, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValid(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,1,1],[1,2,3],[1,2,3]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 1, 1}, new int[]{1, 2, 3}, new int[]{1, 2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValid(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
