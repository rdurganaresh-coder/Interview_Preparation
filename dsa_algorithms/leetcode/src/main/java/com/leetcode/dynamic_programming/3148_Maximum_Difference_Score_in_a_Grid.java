package com.leetcode.dynamic_programming;

class Solution3148 {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        final int inf = 1 << 30;
        int ans = -inf;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int mi = inf;
                if (i > 0) {
                    mi = Math.min(mi, f[i - 1][j]);
                }
                if (j > 0) {
                    mi = Math.min(mi, f[i][j - 1]);
                }
                ans = Math.max(ans, grid.get(i).get(j) - mi);
                f[i][j] = Math.min(grid.get(i).get(j), mi);
            }
        }
        return ans;
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
        Solution3148 _tcSol = new Solution3148();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(9, 5, 7, 3), _tcL(8, 9, 6, 1), _tcL(6, 7, 14, 3), _tcL(2, 5, 3, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[4,3,2],[3,2,1]]");
        try {
            List<List<Integer>> grid = _tcL(_tcL(4, 3, 2), _tcL(3, 2, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}