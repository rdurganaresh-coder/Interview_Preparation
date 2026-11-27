package com.leetcode.matrices_grids;

class Solution2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (var row : grid) {
            for (int j = 0; j < n; ++j) {
                int w = String.valueOf(row[j]).length();
                ans[j] = Math.max(ans[j], w);
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
        Solution2639 _tcSol = new Solution2639();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1],[22],[333]]");
        try {
            int[][] grid = new int[][]{new int[]{1}, new int[]{22}, new int[]{333}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findColumnWidth(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[-15,1,3],[15,7,12],[5,6,-2]]");
        try {
            int[][] grid = new int[][]{new int[]{-15, 1, 3}, new int[]{15, 7, 12}, new int[]{5, 6, -2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findColumnWidth(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,2]");
        System.out.println();
    }
}