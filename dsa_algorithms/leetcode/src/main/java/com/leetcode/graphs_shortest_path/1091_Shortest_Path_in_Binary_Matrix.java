package com.leetcode.graphs_shortest_path;

class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        grid[0][0] = 1;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        for (int ans = 1; !q.isEmpty(); ++ans) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                int i = p[0], j = p[1];
                if (i == n - 1 && j == n - 1) {
                    return ans;
                }
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                            grid[x][y] = 1;
                            q.offer(new int[] {x, y});
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
        Solution1091 _tcSol = new Solution1091();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1],[1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathBinaryMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,0],[1,1,0],[1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0}, new int[]{1, 1, 0}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathBinaryMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,0,0],[1,1,0],[1,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0}, new int[]{1, 1, 0}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestPathBinaryMatrix(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}