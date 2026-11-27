package com.leetcode.graphs_shortest_path;

class Solution0505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        final int inf = 1 << 30;
        int[][] dist = new int[m][n];
        for (var row : dist) {
            Arrays.fill(row, inf);
        }
        int si = start[0], sj = start[1];
        int di = destination[0], dj = destination[1];
        dist[si][sj] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {si, sj});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            var p = q.poll();
            int i = p[0], j = p[1];
            for (int d = 0; d < 4; ++d) {
                int x = i, y = j, k = dist[i][j];
                int a = dirs[d], b = dirs[d + 1];
                while (
                    x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0) {
                    x += a;
                    y += b;
                    ++k;
                }
                if (k < dist[x][y]) {
                    dist[x][y] = k;
                    q.offer(new int[] {x, y});
                }
            }
        }
        return dist[di][dj] == inf ? -1 : dist[di][dj];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0505 _tcSol = new Solution0505();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 1, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}};
            int[] start = new int[]{0, 4};
            int[] destination = new int[]{4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistance(maze, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, new int[]{1, 1, 0, 1, 1}, new int[]{0, 0, 0, 0, 0}};
            int[] start = new int[]{0, 4};
            int[] destination = new int[]{3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistance(maze, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]");
        try {
            int[][] maze = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1}, new int[]{0, 1, 0, 0, 0}};
            int[] start = new int[]{4, 3};
            int[] destination = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistance(maze, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}