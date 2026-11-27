package com.leetcode.arrays_hashing_greedy;

class Solution1970 {
    private int[][] cells;
    private int m;
    private int n;

    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1, r = cells.length;
        this.cells = cells;
        this.m = row;
        this.n = col;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k) {
        int[][] g = new int[m][n];
        for (int i = 0; i < k; i++) {
            g[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        final int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            if (g[0][j] == 0) {
                q.offer(new int[] {0, j});
                g[0][j] = 1;
            }
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            if (x == m - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] == 0) {
                    q.offer(new int[] {nx, ny});
                    g[nx][ny] = 1;
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
        Solution1970 _tcSol = new Solution1970();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]");
        try {
            int row = 2;
            int col = 2;
            int[][] cells = new int[][]{new int[]{1, 1}, new int[]{2, 1}, new int[]{1, 2}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.latestDayToCross(row, col, cells)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]");
        try {
            int row = 2;
            int col = 2;
            int[][] cells = new int[][]{new int[]{1, 1}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.latestDayToCross(row, col, cells)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]");
        try {
            int row = 3;
            int col = 3;
            int[][] cells = new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{3, 3}, new int[]{2, 2}, new int[]{1, 1}, new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 2}, new int[]{3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.latestDayToCross(row, col, cells)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
