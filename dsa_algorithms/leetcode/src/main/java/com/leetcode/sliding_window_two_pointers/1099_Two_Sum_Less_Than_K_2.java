package com.leetcode.sliding_window_two_pointers;

class Solution1099_2 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0, j = nums.length - 1; i < j;) {
            int s = nums[i] + nums[j];
            if (s < k) {
                ans = Math.max(ans, s);
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1099_2 _tcSol = new Solution1099_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [34,23,1,24,75,33,54,8], k = 60");
        try {
            int[] nums = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
            int k = 60;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSumLessThanK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "58");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,20,30], k = 15");
        try {
            int[] nums = new int[]{10, 20, 30};
            int k = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSumLessThanK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}