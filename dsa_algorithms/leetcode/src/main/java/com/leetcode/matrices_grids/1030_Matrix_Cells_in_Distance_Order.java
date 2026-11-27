package com.leetcode.matrices_grids;

class Solution1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {rCenter, cCenter});
        boolean[][] vis = new boolean[rows][cols];
        vis[rCenter][cCenter] = true;
        int[][] ans = new int[rows * cols][2];
        int[] dirs = {-1, 0, 1, 0, -1};
        int idx = 0;
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                var p = q.poll();
                ans[idx++] = p;
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && !vis[x][y]) {
                        vis[x][y] = true;
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1030 _tcSol = new Solution1030();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rows = 1, cols = 2, rCenter = 0, cCenter = 0");
        try {
            int rows = 1;
            int cols = 2;
            int rCenter = 0;
            int cCenter = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.allCellsDistOrder(rows, cols, rCenter, cCenter)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0],[0,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rows = 2, cols = 2, rCenter = 0, cCenter = 1");
        try {
            int rows = 2;
            int cols = 2;
            int rCenter = 0;
            int cCenter = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.allCellsDistOrder(rows, cols, rCenter, cCenter)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[0,0],[1,1],[1,0]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rows = 2, cols = 3, rCenter = 1, cCenter = 2");
        try {
            int rows = 2;
            int cols = 3;
            int rCenter = 1;
            int cCenter = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.allCellsDistOrder(rows, cols, rCenter, cCenter)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]");
        System.out.println();
    }
}
