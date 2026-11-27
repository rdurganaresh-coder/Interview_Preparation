package com.leetcode.matrices_grids;

class Solution1001 {
    private int n;
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        this.n = n;
        Set<Long> s = new HashSet<>();
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();
        for (var lamp : lamps) {
            int i = lamp[0], j = lamp[1];
            if (s.add(f(i, j))) {
                merge(row, i, 1);
                merge(col, j, 1);
                merge(diag1, i - j, 1);
                merge(diag2, i + j, 1);
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int k = 0; k < m; ++k) {
            int i = queries[k][0], j = queries[k][1];
            if (exist(row, i) || exist(col, j) || exist(diag1, i - j) || exist(diag2, i + j)) {
                ans[k] = 1;
            }
            for (int x = i - 1; x <= i + 1; ++x) {
                for (int y = j - 1; y <= j + 1; ++y) {
                    if (x < 0 || x >= n || y < 0 || y >= n || !s.contains(f(x, y))) {
                        continue;
                    }
                    s.remove(f(x, y));
                    merge(row, x, -1);
                    merge(col, y, -1);
                    merge(diag1, x - y, -1);
                    merge(diag2, x + y, -1);
                }
            }
        }
        return ans;
    }

    private void merge(Map<Integer, Integer> cnt, int x, int d) {
        if (cnt.merge(x, d, Integer::sum) == 0) {
            cnt.remove(x);
        }
    }

    private boolean exist(Map<Integer, Integer> cnt, int x) {
        return cnt.getOrDefault(x, 0) > 0;
    }

    private long f(long i, long j) {
        return i * n + j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1001 _tcSol = new Solution1001();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]");
        try {
            int n = 5;
            int[][] lamps = new int[][]{new int[]{0, 0}, new int[]{4, 4}};
            int[][] queries = new int[][]{new int[]{1, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gridIllumination(n, lamps, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]");
        try {
            int n = 5;
            int[][] lamps = new int[][]{new int[]{0, 0}, new int[]{4, 4}};
            int[][] queries = new int[][]{new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gridIllumination(n, lamps, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]");
        try {
            int n = 5;
            int[][] lamps = new int[][]{new int[]{0, 0}, new int[]{0, 4}};
            int[][] queries = new int[][]{new int[]{0, 4}, new int[]{0, 1}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gridIllumination(n, lamps, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,0]");
        System.out.println();
    }
}