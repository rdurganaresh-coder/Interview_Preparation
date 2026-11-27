package com.leetcode.graphs_shortest_path;

class Solution1730 {
    private int[] dirs = {-1, 0, 1, 0, -1};

    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0, x = 1; i < m && x == 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '*') {
                    q.offer(new int[] {i, j});
                    x = 0;
                    break;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            ++ans;
            for (int t = q.size(); t > 0; --t) {
                var p = q.poll();
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k];
                    int y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == '#') {
                            return ans;
                        }
                        if (grid[x][y] == 'O') {
                            grid[x][y] = 'X';
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
        Solution1730 _tcSol = new Solution1730();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"*\",\"O\",\"O\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"#\",\"O\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'X', 'X', 'X', 'X', 'X', 'X'}, new char[]{'X', '*', 'O', 'O', 'O', 'X'}, new char[]{'X', 'O', 'O', '#', 'O', 'X'}, new char[]{'X', 'X', 'X', 'X', 'X', 'X'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFood(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"*\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"#\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'X', 'X', 'X', 'X', 'X'}, new char[]{'X', '*', 'X', 'O', 'X'}, new char[]{'X', 'O', 'X', '#', 'X'}, new char[]{'X', 'X', 'X', 'X', 'X'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFood(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"*\",\"O\",\"X\",\"O\",\"#\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"O\",\"O\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"O\",\"O\",\"#\",\"O\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, new char[]{'X', '*', 'O', 'X', 'O', '#', 'O', 'X'}, new char[]{'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'}, new char[]{'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'}, new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFood(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "grid = [[\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"*\",\"O\",\"X\",\"O\",\"#\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"O\",\"O\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"O\",\"O\",\"#\",\"O\",\"X\"],[\"O\",\"O\",\"O\",\"O\",\"O\",\"O\",\"O\",\"O\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, new char[]{'X', '*', 'O', 'X', 'O', '#', 'O', 'X'}, new char[]{'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'}, new char[]{'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'}, new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getFood(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}