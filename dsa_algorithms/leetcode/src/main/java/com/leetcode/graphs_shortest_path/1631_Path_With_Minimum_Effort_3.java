package com.leetcode.graphs_shortest_path;

class Solution1631_3 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (var row : dist) {
            Arrays.fill(row, 1 << 30);
        }
        dist[0][0] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int t = p[0], i = p[1], j = p[2];
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int d = Math.max(t, Math.abs(heights[x][y] - heights[i][j]));
                    if (d < dist[x][y]) {
                        dist[x][y] = d;
                        pq.offer(new int[] {d, x, y});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1631_3 _tcSol = new Solution1631_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [[1,2,2],[3,8,2],[5,3,5]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 2}, new int[]{3, 8, 2}, new int[]{5, 3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffortPath(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [[1,2,3],[3,8,4],[5,3,5]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 3}, new int[]{3, 8, 4}, new int[]{5, 3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffortPath(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]");
        try {
            int[][] heights = new int[][]{new int[]{1, 2, 1, 1, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 1, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffortPath(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}