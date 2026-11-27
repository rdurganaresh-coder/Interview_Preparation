package com.leetcode.arrays_hashing_greedy;

class Solution2290 {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        boolean[][] vis = new boolean[m][n];
        while (true) {
            var p = q.poll();
            int i = p[0], j = p[1], k = p[2];
            if (i == m - 1 && j == n - 1) {
                return k;
            }
            if (vis[i][j]) {
                continue;
            }
            vis[i][j] = true;
            for (int h = 0; h < 4; ++h) {
                int x = i + dirs[h], y = j + dirs[h + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 0) {
                        q.offerFirst(new int[] {x, y, k});
                    } else {
                        q.offerLast(new int[] {x, y, k + 1});
                    }
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
        Solution2290 _tcSol = new Solution2290();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,1],[1,1,0],[1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumObstacles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0, 0, 0}, new int[]{0, 1, 0, 1, 0}, new int[]{0, 0, 0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumObstacles(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}