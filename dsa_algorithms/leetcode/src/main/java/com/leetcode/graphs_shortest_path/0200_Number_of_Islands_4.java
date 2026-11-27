package com.leetcode.graphs_shortest_path;

class Solution0200_4 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> stk = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    stk.push(new int[] {i, j});
                    while (!stk.isEmpty()) {
                        int[] cur = stk.pop();
                        int a = cur[0], b = cur[1];
                        for (int k = 0; k < 4; ++k) {
                            int x = a + dirs[k];
                            int y = b + dirs[k + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                stk.push(new int[] {x, y});
                            }
                        }
                    }
                    ++ans;
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
        Solution0200_4 _tcSol = new Solution0200_4();
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
