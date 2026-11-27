package com.leetcode.arrays_hashing_greedy;

class Solution1388 {
    private int n;

    public int maxSizeSlices(int[] slices) {
        n = slices.length / 3;
        int[] nums = new int[slices.length - 1];
        System.arraycopy(slices, 1, nums, 0, nums.length);
        int a = g(nums);
        System.arraycopy(slices, 0, nums, 0, nums.length);
        int b = g(nums);
        return Math.max(a, b);
    }

    private int g(int[] nums) {
        int m = nums.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = Math.max(f[i - 1][j], (i >= 2 ? f[i - 2][j - 1] : 0) + nums[i - 1]);
            }
        }
        return f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1388 _tcSol = new Solution1388();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "slices = [1,2,3,4,5,6]");
        try {
            int[] slices = new int[]{1, 2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSizeSlices(slices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "slices = [8,9,8,6,1,1]");
        try {
            int[] slices = new int[]{8, 9, 8, 6, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSizeSlices(slices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}