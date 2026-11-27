package com.leetcode.matrices_grids;

class Solution2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] g = new int[m][n];
        for (var e : guards) {
            g[e[0]][e[1]] = 2;
        }
        for (var e : walls) {
            g[e[0]][e[1]] = 2;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (var e : guards) {
            for (int k = 0; k < 4; ++k) {
                int x = e[0], y = e[1];
                int a = dirs[k], b = dirs[k + 1];
                while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && g[x + a][y + b] < 2) {
                    x += a;
                    y += b;
                    g[x][y] = 1;
                }
            }
        }
        int ans = 0;
        for (var row : g) {
            for (int v : row) {
                if (v == 0) {
                    ++ans;
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
        Solution2257 _tcSol = new Solution2257();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]");
        try {
            int m = 4;
            int n = 6;
            int[][] guards = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 3}};
            int[][] walls = new int[][]{new int[]{0, 1}, new int[]{2, 2}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countUnguarded(m, n, guards, walls)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]");
        try {
            int m = 3;
            int n = 3;
            int[][] guards = new int[][]{new int[]{1, 1}};
            int[][] walls = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{2, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countUnguarded(m, n, guards, walls)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}