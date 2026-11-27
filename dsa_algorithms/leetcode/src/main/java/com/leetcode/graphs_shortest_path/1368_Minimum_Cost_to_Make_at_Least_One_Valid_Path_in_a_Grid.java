package com.leetcode.graphs_shortest_path;

class Solution1368 {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        int[][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1], d = p[2];
            if (i == m - 1 && j == n - 1) {
                return d;
            }
            if (vis[i][j]) {
                continue;
            }
            vis[i][j] = true;
            for (int k = 1; k <= 4; ++k) {
                int x = i + dirs[k][0], y = j + dirs[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[i][j] == k) {
                        q.offerFirst(new int[] {x, y, d});
                    } else {
                        q.offer(new int[] {x, y, d + 1});
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
        Solution1368 _tcSol = new Solution1368();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1, 1}, new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}, new int[]{2, 2, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,3],[3,2,2],[1,1,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 3}, new int[]{3, 2, 2}, new int[]{1, 1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,2],[4,3]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}