package com.leetcode.dynamic_programming;

class Solution3276 {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int mx = 0;
        boolean[][] g = new boolean[101][m + 1];
        for (int i = 0; i < m; ++i) {
            for (int x : grid.get(i)) {
                g[x][i] = true;
                mx = Math.max(mx, x);
            }
        }
        int[][] f = new int[mx + 1][1 << m];
        for (int i = 1; i <= mx; ++i) {
            for (int j = 0; j < 1 << m; ++j) {
                f[i][j] = f[i - 1][j];
                for (int k = 0; k < m; ++k) {
                    if (g[i][k] && (j >> k & 1) == 1) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j ^ 1 << k] + i);
                    }
                }
            }
        }
        return f[mx][(1 << m) - 1];
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
        Solution3276 _tcSol = new Solution3276();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,3,2],[1,1,1]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(1, 2, 3), _tcL(4, 3, 2), _tcL(1, 1, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[8,7,6],[8,3,2]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(8, 7, 6), _tcL(8, 3, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}
