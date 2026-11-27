package com.leetcode.graphs_shortest_path;

class Solution1102 {
    private int[] p;

    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        p = new int[m * n];
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                q.add(new int[] {grid[i][j], i, j});
                p[i * n + j] = i * n + j;
            }
        }
        q.sort((a, b) -> b[0] - a[0]);
        boolean[][] vis = new boolean[m][n];
        int[] dirs = {-1, 0, 1, 0, -1};
        int ans = 0;
        for (int i = 0; find(0) != find(m * n - 1); ++i) {
            int[] t = q.get(i);
            vis[t[1]][t[2]] = true;
            ans = t[0];
            for (int k = 0; k < 4; ++k) {
                int x = t[1] + dirs[k], y = t[2] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y]) {
                    p[find(x * n + y)] = find(t[1] * n + t[2]);
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1102 _tcSol = new Solution1102();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[5,4,5],[1,2,6],[7,4,6]]");
        try {
            int[][] grid = new int[][]{new int[]{5, 4, 5}, new int[]{1, 2, 6}, new int[]{7, 4, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMinimumPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 2, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMinimumPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]");
        try {
            int[][] grid = new int[][]{new int[]{3, 4, 6, 3, 4}, new int[]{0, 2, 1, 1, 7}, new int[]{8, 8, 3, 2, 7}, new int[]{3, 2, 4, 9, 8}, new int[]{4, 1, 2, 0, 0}, new int[]{4, 6, 5, 4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMinimumPath(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}