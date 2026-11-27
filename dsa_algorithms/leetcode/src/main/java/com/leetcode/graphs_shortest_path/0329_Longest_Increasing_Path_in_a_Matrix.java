package com.leetcode.graphs_shortest_path;

class Solution0329 {
    private int m;
    private int n;
    private int[][] matrix;
    private int[][] f;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        f = new int[m][n];
        this.matrix = matrix;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                f[i][j] = Math.max(f[i][j], dfs(x, y));
            }
        }
        return ++f[i][j];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0329 _tcSol = new Solution0329();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[9,9,4],[6,6,8],[2,1,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{9, 9, 4}, new int[]{6, 6, 8}, new int[]{2, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestIncreasingPath(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[3,4,5],[3,2,6],[2,2,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{3, 4, 5}, new int[]{3, 2, 6}, new int[]{2, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestIncreasingPath(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[1]]");
        try {
            int[][] matrix = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestIncreasingPath(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}