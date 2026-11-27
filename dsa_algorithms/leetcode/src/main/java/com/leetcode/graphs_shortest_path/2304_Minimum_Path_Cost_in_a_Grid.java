package com.leetcode.graphs_shortest_path;

class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[] f = grid[0];
        final int inf = 1 << 30;
        for (int i = 1; i < m; ++i) {
            int[] g = new int[n];
            Arrays.fill(g, inf);
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    g[j] = Math.min(g[j], f[k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
            f = g;
        }

        // return Arrays.stream(f).min().getAsInt();
        int ans = inf;
        for (int v : f) {
            ans = Math.min(ans, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2304 _tcSol = new Solution2304();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]");
        try {
            int[][] grid = new int[][]{new int[]{5, 3}, new int[]{4, 0}, new int[]{2, 1}};
            int[][] moveCost = new int[][]{new int[]{9, 8}, new int[]{1, 5}, new int[]{10, 12}, new int[]{18, 6}, new int[]{2, 4}, new int[]{14, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPathCost(grid, moveCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]");
        try {
            int[][] grid = new int[][]{new int[]{5, 1, 2}, new int[]{4, 0, 3}};
            int[][] moveCost = new int[][]{new int[]{12, 10, 15}, new int[]{20, 23, 8}, new int[]{21, 7, 1}, new int[]{8, 1, 13}, new int[]{9, 10, 25}, new int[]{5, 3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPathCost(grid, moveCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}