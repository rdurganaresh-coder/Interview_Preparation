package com.leetcode.arrays_hashing_greedy;

class Solution0910 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n - 1] - nums[0];
        for (int i = 1; i < n; ++i) {
            int mi = Math.min(nums[0] + k, nums[i] - k);
            int mx = Math.max(nums[i - 1] + k, nums[n - 1] - k);
            ans = Math.min(ans, mx - mi);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0910 _tcSol = new Solution0910();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1], k = 0");
        try {
            int[] nums = new int[]{1};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRangeII(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,10], k = 2");
        try {
            int[] nums = new int[]{0, 10};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRangeII(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,6], k = 3");
        try {
            int[] nums = new int[]{1, 3, 6};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestRangeII(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}