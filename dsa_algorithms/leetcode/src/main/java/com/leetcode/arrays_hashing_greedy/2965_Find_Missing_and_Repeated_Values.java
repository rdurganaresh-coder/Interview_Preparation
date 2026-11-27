package com.leetcode.arrays_hashing_greedy;

class Solution2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        int[] ans = new int[2];
        for (int[] row : grid) {
            for (int x : row) {
                if (++cnt[x] == 2) {
                    ans[0] = x;
                }
            }
        }
        for (int x = 1;; ++x) {
            if (cnt[x] == 0) {
                ans[1] = x;
                return ans;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2965 _tcSol = new Solution2965();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,3],[2,2]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 3}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMissingAndRepeatedValues(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[9,1,7],[8,9,2],[3,4,6]]");
        try {
            int[][] grid = new int[][]{new int[]{9, 1, 7}, new int[]{8, 9, 2}, new int[]{3, 4, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMissingAndRepeatedValues(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,5]");
        System.out.println();
    }
}