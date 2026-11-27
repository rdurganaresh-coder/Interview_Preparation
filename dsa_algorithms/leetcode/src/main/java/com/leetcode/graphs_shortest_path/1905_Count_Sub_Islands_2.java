package com.leetcode.graphs_shortest_path;

class Solution1905_2 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> stk = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1) {
                    ans += flood(grid1, grid2, stk, dirs, i, j);
                }
            }
        }
        return ans;
    }

    private int flood(int[][] grid1, int[][] grid2, Deque<int[]> stk, int[] dirs, int i, int j) {
        int m = grid1.length, n = grid1[0].length;
        int ok = 1;
        grid2[i][j] = 0;
        stk.push(new int[] {i, j});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            i = cur[0];
            j = cur[1];
            ok &= grid1[i][j];
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                    grid2[x][y] = 0;
                    stk.push(new int[] {x, y});
                }
            }
        }
        return ok;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1905_2 _tcSol = new Solution1905_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]");
        try {
            int[][] grid1 = new int[][]{new int[]{1, 1, 1, 0, 0}, new int[]{0, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 0, 1, 1}};
            int[][] grid2 = new int[][]{new int[]{1, 1, 1, 0, 0}, new int[]{0, 0, 1, 1, 1}, new int[]{0, 1, 0, 0, 0}, new int[]{1, 0, 1, 1, 0}, new int[]{0, 1, 0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubIslands(grid1, grid2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]");
        try {
            int[][] grid1 = new int[][]{new int[]{1, 0, 1, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}};
            int[][] grid2 = new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 1, 0, 1, 0}, new int[]{0, 1, 0, 1, 0}, new int[]{1, 0, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubIslands(grid1, grid2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
