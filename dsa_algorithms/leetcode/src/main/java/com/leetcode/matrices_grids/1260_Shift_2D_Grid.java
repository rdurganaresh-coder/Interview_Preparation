package com.leetcode.matrices_grids;

class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add(0);
            }
            ans.add(row);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int idx = (i * n + j + k) % (m * n);
                int x = idx / n, y = idx % n;
                ans.get(x).set(y, grid[i][j]);
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
        Solution1260 _tcSol = new Solution1260();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftGrid(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[9,1,2],[3,4,5],[6,7,8]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4");
        try {
            int[][] grid = new int[][]{new int[]{3, 8, 1, 9}, new int[]{19, 7, 2, 5}, new int[]{4, 6, 11, 10}, new int[]{12, 0, 21, 13}};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftGrid(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftGrid(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,3],[4,5,6],[7,8,9]]");
        System.out.println();
    }
}