package com.leetcode.matrices_grids;

class Solution0054_2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        int i = 0, j = 0, k = 0;
        List<Integer> ans = new ArrayList<>();
        for (int h = m * n; h > 0; --h) {
            ans.add(matrix[i][j]);
            matrix[i][j] += 300;
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] > 100) {
                k = (k + 1) % 4;
            }
            i += dirs[k];
            j += dirs[k + 1];
        }
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                matrix[i][j] -= 300;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0054_2 _tcSol = new Solution0054_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.spiralOrder(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,6,9,8,7,4,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}};
            System.out.println("  Output  : " + _tcShow(_tcSol.spiralOrder(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4,8,12,11,10,9,5,6,7]");
        System.out.println();
    }
}
