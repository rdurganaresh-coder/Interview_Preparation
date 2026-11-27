package com.leetcode.graphs_shortest_path;

class Solution0200_2 {
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    bfs(i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j) {
        grid[i][j] = '0';
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int k = 0; k < 4; ++k) {
                int x = p[0] + dirs[k];
                int y = p[1] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                    q.offer(new int[] {x, y});
                    grid[x][y] = '0';
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0200_2 _tcSol = new Solution0200_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [ [\"1\",\"1\",\"1\",\"1\",\"0\"], [\"1\",\"1\",\"0\",\"1\",\"0\"], [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"0\",\"0\",\"0\",\"0\",\"0\"] ]");
        try {
            char[][] grid = new char[][]{new char[]{'1', '1', '1', '1', '0'}, new char[]{'1', '1', '0', '1', '0'}, new char[]{'1', '1', '0', '0', '0'}, new char[]{'0', '0', '0', '0', '0'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numIslands(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [ [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"0\",\"0\",\"1\",\"0\",\"0\"], [\"0\",\"0\",\"0\",\"1\",\"1\"] ]");
        try {
            char[][] grid = new char[][]{new char[]{'1', '1', '0', '0', '0'}, new char[]{'1', '1', '0', '0', '0'}, new char[]{'0', '0', '1', '0', '0'}, new char[]{'0', '0', '0', '1', '1'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numIslands(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}