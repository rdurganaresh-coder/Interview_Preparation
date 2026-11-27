package com.leetcode.arrays_hashing_greedy;

class Solution0296 {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        int i = rows.get(rows.size() >> 1);
        int j = cols.get(cols.size() >> 1);
        return f(rows, i) + f(cols, j);
    }

    private int f(List<Integer> arr, int x) {
        int s = 0;
        for (int v : arr) {
            s += Math.abs(v - x);
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0296 _tcSol = new Solution0296();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTotalDistance(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTotalDistance(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}