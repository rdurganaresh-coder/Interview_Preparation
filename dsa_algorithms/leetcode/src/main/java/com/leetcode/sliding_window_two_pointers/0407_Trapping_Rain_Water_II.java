package com.leetcode.sliding_window_two_pointers;

class Solution0407 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[] {heightMap[i][j], i, j});
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            var p = pq.poll();
            for (int k = 0; k < 4; ++k) {
                int x = p[1] + dirs[k], y = p[2] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                    ans += Math.max(0, p[0] - heightMap[x][y]);
                    vis[x][y] = true;
                    pq.offer(new int[] {Math.max(p[0], heightMap[x][y]), x, y});
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0407 _tcSol = new Solution0407();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]");
        try {
            int[][] heightMap = new int[][]{new int[]{1, 4, 3, 1, 3, 2}, new int[]{3, 2, 1, 3, 2, 4}, new int[]{2, 3, 3, 2, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.trapRainWater(heightMap)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]");
        try {
            int[][] heightMap = new int[][]{new int[]{3, 3, 3, 3, 3}, new int[]{3, 2, 2, 2, 3}, new int[]{3, 2, 1, 2, 3}, new int[]{3, 2, 2, 2, 3}, new int[]{3, 3, 3, 3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.trapRainWater(heightMap)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}