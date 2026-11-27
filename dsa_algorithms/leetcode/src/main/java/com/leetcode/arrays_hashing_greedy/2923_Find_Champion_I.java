package com.leetcode.arrays_hashing_greedy;

class Solution2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0;; ++i) {
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && grid[i][j] == 1) {
                    ++cnt;
                }
            }
            if (cnt == n - 1) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2923 _tcSol = new Solution2923();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1],[0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findChampion(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,1],[1,0,1],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 1}, new int[]{1, 0, 1}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findChampion(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}