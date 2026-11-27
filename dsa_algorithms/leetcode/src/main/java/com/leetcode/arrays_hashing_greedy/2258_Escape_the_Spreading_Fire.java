package com.leetcode.arrays_hashing_greedy;

class Solution2258 {
    private int[][] grid;
    private boolean[][] fire;
    private boolean[][] vis;
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private int m;
    private int n;

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        fire = new boolean[m][n];
        vis = new boolean[m][n];
        int l = -1, r = m * n;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l == m * n ? 1000000000 : l;
    }

    private boolean check(int t) {
        for (int i = 0; i < m; ++i) {
            Arrays.fill(fire[i], false);
            Arrays.fill(vis[i], false);
        }
        Deque<int[]> q1 = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q1.offer(new int[] {i, j});
                    fire[i][j] = true;
                }
            }
        }
        for (; t > 0 && !q1.isEmpty(); --t) {
            q1 = spread(q1);
        }
        if (fire[0][0]) {
            return false;
        }
        Deque<int[]> q2 = new ArrayDeque<>();
        q2.offer(new int[] {0, 0});
        vis[0][0] = true;
        for (; !q2.isEmpty(); q1 = spread(q1)) {
            for (int d = q2.size(); d > 0; --d) {
                int[] p = q2.poll();
                if (fire[p[0]][p[1]]) {
                    continue;
                }
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !fire[x][y] && !vis[x][y]
                        && grid[x][y] == 0) {
                        if (x == m - 1 && y == n - 1) {
                            return true;
                        }
                        vis[x][y] = true;
                        q2.offer(new int[] {x, y});
                    }
                }
            }
        }
        return false;
    }

    private Deque<int[]> spread(Deque<int[]> q) {
        Deque<int[]> nq = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int k = 0; k < 4; ++k) {
                int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && !fire[x][y] && grid[x][y] == 0) {
                    fire[x][y] = true;
                    nq.offer(new int[] {x, y});
                }
            }
        }
        return nq;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2258 _tcSol = new Solution2258();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 2, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 2, 2, 1, 0}, new int[]{0, 2, 0, 0, 1, 2, 0}, new int[]{0, 0, 2, 2, 2, 0, 2}, new int[]{0, 0, 0, 0, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMinutes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 1, 2, 0}, new int[]{0, 2, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMinutes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0,0,0],[2,2,0],[1,2,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0}, new int[]{2, 2, 0}, new int[]{1, 2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMinutes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1000000000");
        System.out.println();
    }
}