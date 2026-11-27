package com.leetcode.matrices_grids;

class Solution2577 {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (var e : dist) {
            Arrays.fill(e, 1 << 30);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (true) {
            var p = pq.poll();
            int i = p[1], j = p[2];
            if (i == m - 1 && j == n - 1) {
                return p[0];
            }
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int nt = p[0] + 1;
                    if (nt < grid[x][y]) {
                        nt = grid[x][y] + (grid[x][y] - nt) % 2;
                    }
                    if (nt < dist[x][y]) {
                        dist[x][y] = nt;
                        pq.offer(new int[] {nt, x, y});
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
        Solution2577 _tcSol = new Solution2577();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 3, 2}, new int[]{5, 1, 2, 5}, new int[]{4, 3, 8, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,2,4],[3,2,1],[1,0,4]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 2, 4}, new int[]{3, 2, 1}, new int[]{1, 0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}