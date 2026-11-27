package com.leetcode.graphs_shortest_path;

class Solution0463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        ans -= 2;
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        ans -= 2;
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
        Solution0463 _tcSol = new Solution0463();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0, 0}, new int[]{1, 1, 1, 0}, new int[]{0, 1, 0, 0}, new int[]{1, 1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.islandPerimeter(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1]]");
        try {
            int[][] grid = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.islandPerimeter(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.islandPerimeter(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}