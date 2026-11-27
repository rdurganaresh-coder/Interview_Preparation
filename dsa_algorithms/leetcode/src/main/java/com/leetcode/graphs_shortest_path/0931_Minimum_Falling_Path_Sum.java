package com.leetcode.graphs_shortest_path;

class Solution0931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        var f = new int[n];
        for (var row : matrix) {
            var g = f.clone();
            for (int j = 0; j < n; ++j) {
                if (j > 0) {
                    g[j] = Math.min(g[j], f[j - 1]);
                }
                if (j + 1 < n) {
                    g[j] = Math.min(g[j], f[j + 1]);
                }
                g[j] += row[j];
            }
            f = g;
        }
        // return Arrays.stream(f).min().getAsInt();
        int ans = 1 << 30;
        for (int x : f) {
            ans = Math.min(ans, x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0931 _tcSol = new Solution0931();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[2,1,3],[6,5,4],[7,8,9]]");
        try {
            int[][] matrix = new int[][]{new int[]{2, 1, 3}, new int[]{6, 5, 4}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFallingPathSum(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[-19,57],[-40,-5]]");
        try {
            int[][] matrix = new int[][]{new int[]{-19, 57}, new int[]{-40, -5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFallingPathSum(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-59");
        System.out.println();
    }
}