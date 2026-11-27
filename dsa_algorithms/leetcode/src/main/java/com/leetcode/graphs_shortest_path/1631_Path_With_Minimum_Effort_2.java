package com.leetcode.graphs_shortest_path;

class Solution1631_2 {
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1000000;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(heights, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[][] heights, int h) {
        int m = heights.length, n = heights[0].length;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        vis[0][0] = true;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            var p = q.poll();
            int i = p[0], j = p[1];
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]
                    && Math.abs(heights[x][y] - heights[i][j]) <= h) {
                    q.add(new int[] {x, y});
                    vis[x][y] = true;
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
        Solution1631_2 _tcSol = new Solution1631_2();
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