package com.leetcode.matrices_grids;

class Solution1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        Arrays.fill(rows, 1 << 30);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] = Math.min(rows[i], matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rows[i] == cols[j]) {
                    ans.add(rows[i]);
                }
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
        Solution1380 _tcSol = new Solution1380();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[3,7,8],[9,11,13],[15,16,17]]");
        try {
            int[][] matrix = new int[][]{new int[]{3, 7, 8}, new int[]{9, 11, 13}, new int[]{15, 16, 17}};
            System.out.println("  Output  : " + _tcShow(_tcSol.luckyNumbers(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[15]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]");
        try {
            int[][] matrix = new int[][]{new int[]{1, 10, 4, 2}, new int[]{9, 3, 8, 7}, new int[]{15, 16, 17, 12}};
            System.out.println("  Output  : " + _tcShow(_tcSol.luckyNumbers(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[12]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[7,8],[1,2]]");
        try {
            int[][] matrix = new int[][]{new int[]{7, 8}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.luckyNumbers(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7]");
        System.out.println();
    }
}