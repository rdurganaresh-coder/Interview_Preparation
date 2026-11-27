package com.leetcode.graphs_shortest_path;

class Solution0499 {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int r = ball[0], c = ball[1];
        int rh = hole[0], ch = hole[1];
        Deque<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[r][c] = 0;
        String[][] path = new String[m][n];
        path[r][c] = "";
        int[][] dirs = {{-1, 0, 'u'}, {1, 0, 'd'}, {0, -1, 'l'}, {0, 1, 'r'}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int[] dir : dirs) {
                int a = dir[0], b = dir[1];
                String d = String.valueOf((char) (dir[2]));
                int x = i, y = j;
                int step = dist[i][j];
                while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0
                    && (x != rh || y != ch)) {
                    x += a;
                    y += b;
                    ++step;
                }
                if (dist[x][y] > step
                    || (dist[x][y] == step && (path[i][j] + d).compareTo(path[x][y]) < 0)) {
                    dist[x][y] = step;
                    path[x][y] = path[i][j] + d;
                    if (x != rh || y != ch) {
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
        return path[rh][ch] == null ? "impossible" : path[rh][ch];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0499 _tcSol = new Solution0499();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], ball = [4,3], hole = [0,1]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1}, new int[]{0, 1, 0, 0, 0}};
            int[] ball = new int[]{4, 3};
            int[] hole = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestWay(maze, ball, hole)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lul\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], ball = [4,3], hole = [3,0]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1}, new int[]{0, 1, 0, 0, 0}};
            int[] ball = new int[]{4, 3};
            int[] hole = new int[]{3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestWay(maze, ball, hole)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"impossible\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maze = [[0,0,0,0,0,0,0],[0,0,1,0,0,1,0],[0,0,0,0,1,0,0],[0,0,0,0,0,0,1]], ball = [0,4], hole = [3,5]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 0, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 0, 1, 0}, new int[]{0, 0, 0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 1}};
            int[] ball = new int[]{0, 4};
            int[] hole = new int[]{3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestWay(maze, ball, hole)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dldr\"");
        System.out.println();
    }
}