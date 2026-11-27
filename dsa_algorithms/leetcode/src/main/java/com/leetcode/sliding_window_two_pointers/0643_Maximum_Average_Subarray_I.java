package com.leetcode.sliding_window_two_pointers;

class Solution0643 {
    public double findMaxAverage(int[] nums, int k) {
        int s = 0;
        for (int i = 0; i < k; ++i) {
            s += nums[i];
        }
        int ans = s;
        for (int i = k; i < nums.length; ++i) {
            s += (nums[i] - nums[i - k]);
            ans = Math.max(ans, s);
        }
        return ans * 1.0 / k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0643 _tcSol = new Solution0643();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,12,-5,-6,50,3], k = 4");
        try {
            int[] nums = new int[]{1, 12, -5, -6, 50, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxAverage(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12.75000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5], k = 1");
        try {
            int[] nums = new int[]{5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxAverage(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5.00000");
        System.out.println();
    }
}