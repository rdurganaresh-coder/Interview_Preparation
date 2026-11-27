package com.leetcode.graphs_shortest_path;

class Solution0200_3 {
    private int[] p;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        int[] dirs = {1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 2; ++k) {
                        int x = i + dirs[k];
                        int y = j + dirs[k + 1];
                        if (x < m && y < n && grid[x][y] == '1') {
                            p[find(x * n + y)] = find(i * n + j);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && i * n + j == find(i * n + j)) {
                    ++ans;
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
        Solution0200_3 _tcSol = new Solution0200_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [ [\"1\",\"1\",\"1\",\"1\",\"0\"], [\"1\",\"1\",\"0\",\"1\",\"0\"], [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"0\",\"0\",\"0\",\"0\",\"0\"] ]");
        try {
            char[][] grid = new char[][]{new char[]{'1', '1', '1', '1', '0'}, new char[]{'1', '1', '0', '1', '0'}, new char[]{'1', '1', '0', '0', '0'}, new char[]{'0', '0', '0', '0', '0'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numIslands(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [ [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"1\",\"1\",\"0\",\"0\",\"0\"], [\"0\",\"0\",\"1\",\"0\",\"0\"], [\"0\",\"0\",\"0\",\"1\",\"1\"] ]");
        try {
            char[][] grid = new char[][]{new char[]{'1', '1', '0', '0', '0'}, new char[]{'1', '1', '0', '0', '0'}, new char[]{'0', '0', '1', '0', '0'}, new char[]{'0', '0', '0', '1', '1'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numIslands(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}