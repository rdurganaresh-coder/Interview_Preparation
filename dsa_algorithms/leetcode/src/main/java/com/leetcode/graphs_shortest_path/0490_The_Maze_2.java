package com.leetcode.graphs_shortest_path;

class Solution0490_2 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[start[0]][start[1]] = true;
        Deque<int[]> q = new LinkedList<>();
        q.offer(start);
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int k = 0; k < 4; ++k) {
                int x = i, y = j;
                int a = dirs[k], b = dirs[k + 1];
                while (
                    x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0) {
                    x += a;
                    y += b;
                }
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                if (!vis[x][y]) {
                    vis[x][y] = true;
                    q.offer(new int[] {x, y});
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
        Solution0490_2 _tcSol = new Solution0490_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 1, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}};
            int[] start = new int[]{0, 4};
            int[] destination = new int[]{4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasPath(maze, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 1, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}};
            int[] start = new int[]{0, 4};
            int[] destination = new int[]{3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasPath(maze, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1}, new int[]{0, 1, 0, 0, 0}};
            int[] start = new int[]{4, 3};
            int[] destination = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasPath(maze, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}