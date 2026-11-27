package com.leetcode.matrices_grids;

class Solution3446 {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int k = n - 2; k >= 0; --k) {
            int i = k, j = 0;
            List<Integer> t = new ArrayList<>();
            while (i < n && j < n) {
                t.add(grid[i++][j++]);
            }
            Collections.sort(t);
            for (int x : t) {
                grid[--i][--j] = x;
            }
        }
        for (int k = n - 2; k > 0; --k) {
            int i = k, j = n - 1;
            List<Integer> t = new ArrayList<>();
            while (i >= 0 && j >= 0) {
                t.add(grid[i--][j--]);
            }
            Collections.sort(t);
            for (int x : t) {
                grid[++i][++j] = x;
            }
        }
        return grid;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3446 _tcSol = new Solution3446();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,7,3],[9,8,2],[4,5,6]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 7, 3}, new int[]{9, 8, 2}, new int[]{4, 5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[8,2,3],[9,6,7],[4,5,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1],[1,2]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,1],[1,0]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1]]");
        try {
            int[][] grid = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1]]");
        System.out.println();
    }
}
