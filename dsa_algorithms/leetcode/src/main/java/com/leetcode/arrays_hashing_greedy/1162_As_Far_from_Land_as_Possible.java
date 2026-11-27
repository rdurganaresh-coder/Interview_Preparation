package com.leetcode.arrays_hashing_greedy;

class Solution1162 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int ans = -1;
        if (q.isEmpty() || q.size() == n * n) {
            return ans;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.poll();
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1162 _tcSol = new Solution1162();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,1],[0,0,0],[1,0,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 1}, new int[]{0, 0, 0}, new int[]{1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,0,0],[0,0,0],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}