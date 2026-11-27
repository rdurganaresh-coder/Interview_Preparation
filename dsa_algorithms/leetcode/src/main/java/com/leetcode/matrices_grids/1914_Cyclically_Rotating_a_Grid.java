package com.leetcode.matrices_grids;

class Solution1914 {
    private int m;
    private int n;
    private int[][] grid;

    public int[][] rotateGrid(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for (int p = 0; p < Math.min(m, n) / 2; ++p) {
            rotate(p, k);
        }
        return grid;
    }

    private void rotate(int p, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int j = p; j < n - p - 1; ++j) {
            nums.add(grid[p][j]);
        }
        for (int i = p; i < m - p - 1; ++i) {
            nums.add(grid[i][n - p - 1]);
        }
        for (int j = n - p - 1; j > p; --j) {
            nums.add(grid[m - p - 1][j]);
        }
        for (int i = m - p - 1; i > p; --i) {
            nums.add(grid[i][p]);
        }
        int l = nums.size();
        k %= l;
        if (k == 0) {
            return;
        }
        for (int j = p; j < n - p - 1; ++j) {
            grid[p][j] = nums.get(k++ % l);
        }
        for (int i = p; i < m - p - 1; ++i) {
            grid[i][n - p - 1] = nums.get(k++ % l);
        }
        for (int j = n - p - 1; j > p; --j) {
            grid[m - p - 1][j] = nums.get(k++ % l);
        }
        for (int i = m - p - 1; i > p; --i) {
            grid[i][p] = nums.get(k++ % l);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1914 _tcSol = new Solution1914();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[40,10],[30,20]], k = 1");
        try {
            int[][] grid = new int[][]{new int[]{40, 10}, new int[]{30, 20}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateGrid(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[10,20],[40,30]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}, new int[]{13, 14, 15, 16}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateGrid(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]");
        System.out.println();
    }
}