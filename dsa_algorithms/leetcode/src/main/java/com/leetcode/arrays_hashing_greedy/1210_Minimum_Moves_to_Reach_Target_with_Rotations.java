package com.leetcode.arrays_hashing_greedy;

class Solution1210 {
    private int n;
    private int[][] grid;
    private boolean[][] vis;
    private Deque<int[]> q = new ArrayDeque<>();

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        vis = new boolean[n * n][2];
        int[] target = {n * n - 2, n * n - 1};
        q.offer(new int[] {0, 1});
        vis[0][0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                if (p[0] == target[0] && p[1] == target[1]) {
                    return ans;
                }
                int i1 = p[0] / n, j1 = p[0] % n;
                int i2 = p[1] / n, j2 = p[1] % n;
                move(i1, j1 + 1, i2, j2 + 1);
                move(i1 + 1, j1, i2 + 1, j2);
                if (i1 == i2 && i1 + 1 < n && grid[i1 + 1][j2] == 0) {
                    move(i1, j1, i1 + 1, j1);
                }
                if (j1 == j2 && j1 + 1 < n && grid[i2][j1 + 1] == 0) {
                    move(i1, j1, i1, j1 + 1);
                }
            }
            ++ans;
        }
        return -1;
    }

    private void move(int i1, int j1, int i2, int j2) {
        if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < n && i2 >= 0 && i2 < n && j2 >= 0 && j2 < n) {
            int a = i1 * n + j1, b = i2 * n + j2;
            int status = i1 == i2 ? 0 : 1;
            if (!vis[a][status] && grid[i1][j1] == 0 && grid[i2][j2] == 0) {
                q.offer(new int[] {a, b});
                vis[a][status] = true;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1210 _tcSol = new Solution1210();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,0,0,0,0,1], [1,1,0,0,1,0], [0,0,0,0,1,1], [0,0,1,0,1,0], [0,1,1,0,0,0], [0,1,1,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0, 0, 0, 1}, new int[]{1, 1, 0, 0, 1, 0}, new int[]{0, 0, 0, 0, 1, 1}, new int[]{0, 0, 1, 0, 1, 0}, new int[]{0, 1, 1, 0, 0, 0}, new int[]{0, 1, 1, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,1,1,1,1], [0,0,0,0,1,1], [1,1,0,0,0,1], [1,1,1,0,0,1], [1,1,1,0,0,1], [1,1,1,0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1, 1}, new int[]{1, 1, 0, 0, 0, 1}, new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 1, 1, 0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}