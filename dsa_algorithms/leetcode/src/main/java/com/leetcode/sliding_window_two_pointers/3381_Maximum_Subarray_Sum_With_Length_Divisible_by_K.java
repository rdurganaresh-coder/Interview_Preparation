package com.leetcode.sliding_window_two_pointers;

class Solution3381 {
    public long maxSubarraySum(int[] nums, int k) {
        long[] f = new long[k];
        final long inf = 1L << 62;
        Arrays.fill(f, inf);
        f[k - 1] = 0;
        long s = 0;
        long ans = -inf;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            ans = Math.max(ans, s - f[i % k]);
            f[i % k] = Math.min(f[i % k], s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3381 _tcSol = new Solution3381();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2], k = 1");
        try {
            int[] nums = new int[]{1, 2};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,-4,-5], k = 4");
        try {
            int[] nums = new int[]{-1, -2, -3, -4, -5};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-5,1,2,-3,4], k = 2");
        try {
            int[] nums = new int[]{-5, 1, 2, -3, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
