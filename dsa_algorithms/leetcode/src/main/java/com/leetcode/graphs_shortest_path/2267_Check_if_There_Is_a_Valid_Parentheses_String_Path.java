package com.leetcode.graphs_shortest_path;

class Solution2267 {
    private int m, n;
    private char[][] grid;
    private boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 == 1 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        this.grid = grid;
        vis = new boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        if (vis[i][j][k]) {
            return false;
        }
        vis[i][j][k] = true;
        k += grid[i][j] == '(' ? 1 : -1;
        if (k < 0 || k > m - i + n - j) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return k == 0;
        }
        final int[] dirs = {1, 0, 1};
        for (int d = 0; d < 2; ++d) {
            int x = i + dirs[d], y = j + dirs[d + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && dfs(x, y, k)) {
                return true;
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
        Solution2267 _tcSol = new Solution2267();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[\"(\",\"(\",\"(\"],[\")\",\"(\",\")\"],[\"(\",\"(\",\")\"],[\"(\",\"(\",\")\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'(', '(', '('}, new char[]{')', '(', ')'}, new char[]{'(', '(', ')'}, new char[]{'(', '(', ')'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasValidPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[\")\",\")\"],[\"(\",\"(\"]]");
        try {
            char[][] grid = new char[][]{new char[]{')', ')'}, new char[]{'(', '('}};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasValidPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
