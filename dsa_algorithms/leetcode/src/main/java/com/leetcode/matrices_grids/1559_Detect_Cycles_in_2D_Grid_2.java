package com.leetcode.matrices_grids;

class Solution1559_2 {
    private char[][] grid;
    private boolean[][] vis;
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private int m;
    private int n;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!vis[i][j] && dfs(i, j, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int px, int py) {
        vis[x][y] = true;
        for (int k = 0; k < 4; ++k) {
            int nx = x + dirs[k], ny = y + dirs[k + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (grid[nx][ny] != grid[x][y] || (nx == px && ny == py)) {
                    continue;
                }
                if (vis[nx][ny] || dfs(nx, ny, x, y)) {
                    return true;
                }
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
        Solution1559_2 _tcSol = new Solution1559_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"a\",\"a\",\"a\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'a', 'a', 'a', 'a'}, new char[]{'a', 'b', 'b', 'a'}, new char[]{'a', 'b', 'b', 'a'}, new char[]{'a', 'a', 'a', 'a'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.containsCycle(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[\"c\",\"c\",\"c\",\"a\"],[\"c\",\"d\",\"c\",\"c\"],[\"c\",\"c\",\"e\",\"c\"],[\"f\",\"c\",\"c\",\"c\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'c', 'c', 'c', 'a'}, new char[]{'c', 'd', 'c', 'c'}, new char[]{'c', 'c', 'e', 'c'}, new char[]{'f', 'c', 'c', 'c'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.containsCycle(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[\"a\",\"b\",\"b\"],[\"b\",\"z\",\"b\"],[\"b\",\"b\",\"a\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'a', 'b', 'b'}, new char[]{'b', 'z', 'b'}, new char[]{'b', 'b', 'a'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.containsCycle(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
