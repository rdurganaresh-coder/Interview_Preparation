package com.leetcode.arrays_hashing_greedy;

class Solution3283 {
    private Integer[][][] f;
    private Integer[][][] dist;
    private int[][] positions;
    private final int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    private final int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

    public int maxMoves(int kx, int ky, int[][] positions) {
        int n = positions.length;
        final int m = 50;
        dist = new Integer[n + 1][m][m];
        this.positions = positions;
        for (int i = 0; i <= n; ++i) {
            int x = i < n ? positions[i][0] : kx;
            int y = i < n ? positions[i][1] : ky;
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {x, y});
            for (int step = 1; !q.isEmpty(); ++step) {
                for (int k = q.size(); k > 0; --k) {
                    var p = q.poll();
                    int x1 = p[0], y1 = p[1];
                    for (int j = 0; j < 8; ++j) {
                        int x2 = x1 + dx[j], y2 = y1 + dy[j];
                        if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < m && dist[i][x2][y2] == null) {
                            dist[i][x2][y2] = step;
                            q.offer(new int[] {x2, y2});
                        }
                    }
                }
            }
        }
        f = new Integer[n + 1][1 << n][2];
        return dfs(n, (1 << n) - 1, 1);
    }

    private int dfs(int last, int state, int k) {
        if (state == 0) {
            return 0;
        }
        if (f[last][state][k] != null) {
            return f[last][state][k];
        }
        int res = k == 1 ? 0 : Integer.MAX_VALUE;
        for (int i = 0; i < positions.length; ++i) {
            int x = positions[i][0], y = positions[i][1];
            if ((state >> i & 1) == 1) {
                int t = dfs(i, state ^ (1 << i), k ^ 1) + dist[last][x][y];
                res = k == 1 ? Math.max(res, t) : Math.min(res, t);
            }
        }
        return f[last][state][k] = res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3283 _tcSol = new Solution3283();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "kx = 1, ky = 1, positions = [[0,0]]");
        try {
            int kx = 1;
            int ky = 1;
            int[][] positions = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMoves(kx, ky, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "kx = 0, ky = 2, positions = [[1,1],[2,2],[3,3]]");
        try {
            int kx = 0;
            int ky = 2;
            int[][] positions = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMoves(kx, ky, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "kx = 0, ky = 0, positions = [[1,2],[2,4]]");
        try {
            int kx = 0;
            int ky = 0;
            int[][] positions = new int[][]{new int[]{1, 2}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxMoves(kx, ky, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
