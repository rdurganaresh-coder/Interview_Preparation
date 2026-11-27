package com.leetcode.sliding_window_two_pointers;

class Solution0053 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1, f = nums[0]; i < nums.length; ++i) {
            f = Math.max(f, 0) + nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0053 _tcSol = new Solution0053();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-2,1,-3,4,-1,2,1,-5,4]");
        try {
            int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,4,-1,7,8]");
        try {
            int[] nums = new int[]{5, 4, -1, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();
    }
}