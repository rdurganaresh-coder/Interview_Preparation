package com.leetcode.graphs_shortest_path;

class Solution1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] f = new int[n];
        final int inf = 1 << 30;
        for (int[] row : grid) {
            int[] g = row.clone();
            for (int i = 0; i < n; ++i) {
                int t = inf;
                for (int j = 0; j < n; ++j) {
                    if (j != i) {
                        t = Math.min(t, f[j]);
                    }
                }
                g[i] += (t == inf ? 0 : t);
            }
            f = g;
        }
        return Arrays.stream(f).min().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1289 _tcSol = new Solution1289();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFallingPathSum(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[7]]");
        try {
            int[][] grid = new int[][]{new int[]{7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFallingPathSum(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
