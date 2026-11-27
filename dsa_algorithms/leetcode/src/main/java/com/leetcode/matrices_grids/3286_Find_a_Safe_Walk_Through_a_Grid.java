package com.leetcode.matrices_grids;

class Solution3286 {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid.get(0).get(0);
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        final int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i];
                int ny = y + dirs[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                    && dist[nx][ny] > dist[x][y] + grid.get(nx).get(ny)) {
                    dist[nx][ny] = dist[x][y] + grid.get(nx).get(ny);
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return dist[m - 1][n - 1] < health;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3286 _tcSol = new Solution3286();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1");
        try {
            List<List<Integer>> grid = _tcL(_tcL(0, 1, 0, 0, 0), _tcL(0, 1, 0, 1, 0), _tcL(0, 0, 0, 1, 0));
            int health = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findSafeWalk(grid, health)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3");
        try {
            List<List<Integer>> grid = _tcL(_tcL(0, 1, 1, 0, 0, 0), _tcL(1, 0, 1, 0, 0, 0), _tcL(0, 1, 1, 1, 0, 1), _tcL(0, 0, 1, 0, 1, 0));
            int health = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findSafeWalk(grid, health)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5");
        try {
            List<List<Integer>> grid = _tcL(_tcL(1, 1, 1), _tcL(1, 0, 1), _tcL(1, 1, 1));
            int health = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findSafeWalk(grid, health)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
