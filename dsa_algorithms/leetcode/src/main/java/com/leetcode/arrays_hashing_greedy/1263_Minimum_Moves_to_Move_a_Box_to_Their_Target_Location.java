package com.leetcode.arrays_hashing_greedy;

class Solution1263 {
    private int m;
    private int n;
    private char[][] grid;

    public int minPushBox(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int si = 0, sj = 0, bi = 0, bj = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'S') {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 'B') {
                    bi = i;
                    bj = j;
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m * n][m * n];
        q.offer(new int[] {f(si, sj), f(bi, bj), 0});
        vis[f(si, sj)][f(bi, bj)] = true;
        while (!q.isEmpty()) {
            var p = q.poll();
            int d = p[2];
            bi = p[1] / n;
            bj = p[1] % n;
            if (grid[bi][bj] == 'T') {
                return d;
            }
            si = p[0] / n;
            sj = p[0] % n;
            for (int k = 0; k < 4; ++k) {
                int sx = si + dirs[k], sy = sj + dirs[k + 1];
                if (!check(sx, sy)) {
                    continue;
                }
                if (sx == bi && sy == bj) {
                    int bx = bi + dirs[k], by = bj + dirs[k + 1];
                    if (!check(bx, by) || vis[f(sx, sy)][f(bx, by)]) {
                        continue;
                    }
                    vis[f(sx, sy)][f(bx, by)] = true;
                    q.offer(new int[] {f(sx, sy), f(bx, by), d + 1});
                } else if (!vis[f(sx, sy)][f(bi, bj)]) {
                    vis[f(sx, sy)][f(bi, bj)] = true;
                    q.offerFirst(new int[] {f(sx, sy), f(bi, bj), d});
                }
            }
        }
        return -1;
    }

    private int f(int i, int j) {
        return i * n + j;
    }

    private boolean check(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != '#';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1263 _tcSol = new Solution1263();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"], [\"#\",\"T\",\"#\",\"#\",\"#\",\"#\"], [\"#\",\".\",\".\",\"B\",\".\",\"#\"], [\"#\",\".\",\"#\",\"#\",\".\",\"#\"], [\"#\",\".\",\".\",\".\",\"S\",\"#\"], [\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'#', '#', '#', '#', '#', '#'}, new char[]{'#', 'T', '#', '#', '#', '#'}, new char[]{'#', '.', '.', 'B', '.', '#'}, new char[]{'#', '.', '#', '#', '.', '#'}, new char[]{'#', '.', '.', '.', 'S', '#'}, new char[]{'#', '#', '#', '#', '#', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPushBox(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"], [\"#\",\"T\",\"#\",\"#\",\"#\",\"#\"], [\"#\",\".\",\".\",\"B\",\".\",\"#\"], [\"#\",\"#\",\"#\",\"#\",\".\",\"#\"], [\"#\",\".\",\".\",\".\",\"S\",\"#\"], [\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'#', '#', '#', '#', '#', '#'}, new char[]{'#', 'T', '#', '#', '#', '#'}, new char[]{'#', '.', '.', 'B', '.', '#'}, new char[]{'#', '#', '#', '#', '.', '#'}, new char[]{'#', '.', '.', '.', 'S', '#'}, new char[]{'#', '#', '#', '#', '#', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPushBox(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"], [\"#\",\"T\",\".\",\".\",\"#\",\"#\"], [\"#\",\".\",\"#\",\"B\",\".\",\"#\"], [\"#\",\".\",\".\",\".\",\".\",\"#\"], [\"#\",\".\",\".\",\".\",\"S\",\"#\"], [\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'#', '#', '#', '#', '#', '#'}, new char[]{'#', 'T', '.', '.', '#', '#'}, new char[]{'#', '.', '#', 'B', '.', '#'}, new char[]{'#', '.', '.', '.', '.', '#'}, new char[]{'#', '.', '.', '.', 'S', '#'}, new char[]{'#', '#', '#', '#', '#', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPushBox(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}