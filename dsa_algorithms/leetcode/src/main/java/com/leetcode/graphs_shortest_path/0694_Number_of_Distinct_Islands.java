package com.leetcode.graphs_shortest_path;

class Solution0694 {
    private int m;
    private int n;
    private int[][] grid;
    private StringBuilder path = new StringBuilder();

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        Set<String> paths = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j, 0);
                    paths.add(path.toString());
                    path.setLength(0);
                }
            }
        }
        return paths.size();
    }

    private void dfs(int i, int j, int k) {
        grid[i][j] = 0;
        path.append(k);
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int h = 1; h < 5; ++h) {
            int x = i + dirs[h - 1];
            int y = j + dirs[h];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(x, y, h);
            }
        }
        path.append(k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0694 _tcSol = new Solution0694();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 0, 0, 0}, new int[]{0, 0, 0, 1, 1}, new int[]{0, 0, 0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numDistinctIslands(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 0, 1, 1}, new int[]{1, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 1}, new int[]{1, 1, 0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numDistinctIslands(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}