package com.leetcode.sliding_window_two_pointers;

class Solution0713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, l = 0;
        int p = 1;
        for (int r = 0; r < nums.length; ++r) {
            p *= nums[r];
            while (l <= r && p >= k) {
                p /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0713 _tcSol = new Solution0713();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,5,2,6], k = 100");
        try {
            int[] nums = new int[]{10, 5, 2, 6};
            int k = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarrayProductLessThanK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 0");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarrayProductLessThanK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
