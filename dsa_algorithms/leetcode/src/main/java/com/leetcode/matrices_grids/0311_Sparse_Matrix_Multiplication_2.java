package com.leetcode.matrices_grids;

class Solution0311_2 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat2[0].length;
        int[][] ans = new int[m][n];
        var g1 = f(mat1);
        var g2 = f(mat2);
        for (int i = 0; i < m; ++i) {
            for (int[] p : g1[i]) {
                int k = p[0], x = p[1];
                for (int[] q : g2[k]) {
                    int j = q[0], y = q[1];
                    ans[i][j] += x * y;
                }
            }
        }
        return ans;
    }

    private List<int[]>[] f(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<int[]>[] g = new List[m];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] != 0) {
                    g[i].add(new int[] {j, mat[i][j]});
                }
            }
        }
        return g;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0311_2 _tcSol = new Solution0311_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]");
        try {
            int[][] mat1 = new int[][]{new int[]{1, 0, 0}, new int[]{-1, 0, 3}};
            int[][] mat2 = new int[][]{new int[]{7, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(mat1, mat2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[7,0,0],[-7,0,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat1 = [[0]], mat2 = [[0]]");
        try {
            int[][] mat1 = new int[][]{new int[]{0}};
            int[][] mat2 = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(mat1, mat2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0]]");
        System.out.println();
    }
}