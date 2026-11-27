package com.leetcode.graphs_shortest_path;

class Solution1293 {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (k >= m + n - 3) {
            return m + n - 2;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, k});
        boolean[][][] vis = new boolean[m][n][k + 1];
        vis[0][0][k] = true;
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            ++ans;
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.poll();
                k = p[2];
                for (int j = 0; j < 4; ++j) {
                    int x = p[0] + dirs[j];
                    int y = p[1] + dirs[j + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (x == m - 1 && y == n - 1) {
                            return ans;
                        }
                        if (grid[x][y] == 0 && !vis[x][y][k]) {
                            q.offer(new int[] {x, y, k});
                            vis[x][y][k] = true;
                        } else if (grid[x][y] == 1 && k > 0 && !vis[x][y][k - 1]) {
                            q.offer(new int[] {x, y, k - 1});
                            vis[x][y][k - 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1293 _tcSol = new Solution1293();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 0}, new int[]{0, 1, 1}, new int[]{0, 0, 0}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPath(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 0, 0}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPath(grid, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}