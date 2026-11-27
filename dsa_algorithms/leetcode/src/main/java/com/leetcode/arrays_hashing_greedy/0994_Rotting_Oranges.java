package com.leetcode.arrays_hashing_greedy;

class Solution0994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++cnt;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        final int[] dirs = {-1, 0, 1, 0, -1};
        for (int ans = 1; !q.isEmpty() && cnt > 0; ++ans) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                for (int d = 0; d < 4; ++d) {
                    int x = p[0] + dirs[d], y = p[1] + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[] {x, y});
                        if (--cnt == 0) {
                            return ans;
                        }
                    }
                }
            }
        }
        return cnt > 0 ? -1 : 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0994 _tcSol = new Solution0994();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[2,1,1],[1,1,0],[0,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 1, 1}, new int[]{1, 1, 0}, new int[]{0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.orangesRotting(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[2,1,1],[0,1,1],[1,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 1, 1}, new int[]{0, 1, 1}, new int[]{1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.orangesRotting(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0,2]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.orangesRotting(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
