package com.leetcode.matrices_grids;

class Solution2033 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] nums = new int[m * n];
        int mod = grid[0][0] % x;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] % x != mod) {
                    return -1;
                }
                nums[i * n + j] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int mid = nums[nums.length >> 1];
        int ans = 0;
        for (int v : nums) {
            ans += Math.abs(v - mid) / x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2033 _tcSol = new Solution2033();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[2,4],[6,8]], x = 2");
        try {
            int[][] grid = new int[][]{new int[]{2, 4}, new int[]{6, 8}};
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(grid, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,5],[2,3]], x = 1");
        try {
            int[][] grid = new int[][]{new int[]{1, 5}, new int[]{2, 3}};
            int x = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(grid, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]], x = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(grid, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}