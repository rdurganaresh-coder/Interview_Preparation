package com.leetcode.dynamic_programming;

class Solution0213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int l, int r) {
        int f = 0, g = 0;
        for (; l <= r; ++l) {
            int ff = Math.max(f, g);
            g = f + nums[l];
            f = ff;
        }
        return Math.max(f, g);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0213 _tcSol = new Solution0213();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,2]");
        try {
            int[] nums = new int[]{2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.rob(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.rob(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.rob(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}