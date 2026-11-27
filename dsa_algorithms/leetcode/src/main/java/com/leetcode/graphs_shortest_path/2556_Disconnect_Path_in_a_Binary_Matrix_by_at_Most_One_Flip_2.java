package com.leetcode.graphs_shortest_path;

class Solution2556_2 {
    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean a = dfs(grid, m, n);
        grid[0][0] = 1;
        grid[m - 1][n - 1] = 1;
        boolean b = dfs(grid, m, n);
        return !(a && b);
    }

    private boolean dfs(int[][] grid, int m, int n) {
        int[] stk = new int[m * n * 2];
        int top = 0;
        stk[top++] = 0;
        while (top > 0) {
            int cur = stk[--top];
            int i = cur / n;
            int j = cur % n;
            if (i >= m || j >= n || grid[i][j] == 0) {
                continue;
            }
            grid[i][j] = 0;
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            if (j + 1 < n) {
                stk[top++] = i * n + j + 1;
            }
            if (i + 1 < m) {
                stk[top++] = (i + 1) * n + j;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2556_2 _tcSol = new Solution2556_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,0,0],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 0}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToCutPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,0,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToCutPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
