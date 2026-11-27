package com.leetcode.graphs_shortest_path;

class Solution1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        final int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        for (int ans = 1; !q.isEmpty(); ++ans) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                for (int d = 0; d < 4; ++d) {
                    int x = p[0] + dirs[d], y = p[1] + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.') {
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            return ans;
                        }
                        maze[x][y] = '+';
                        q.offer(new int[] {x, y});
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
        Solution1926 _tcSol = new Solution1926();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maze = [[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]], entrance = [1,2]");
        try {
            char[][] maze = new char[][]{new char[]{'+', '+', '.', '+'}, new char[]{'.', '.', '.', '+'}, new char[]{'+', '+', '+', '.'}};
            int[] entrance = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestExit(maze, entrance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maze = [[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]], entrance = [1,0]");
        try {
            char[][] maze = new char[][]{new char[]{'+', '+', '+'}, new char[]{'.', '.', '.'}, new char[]{'+', '+', '+'}};
            int[] entrance = new int[]{1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestExit(maze, entrance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maze = [[\".\",\"+\"]], entrance = [0,0]");
        try {
            char[][] maze = new char[][]{new char[]{'.', '+'}};
            int[] entrance = new int[]{0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestExit(maze, entrance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
