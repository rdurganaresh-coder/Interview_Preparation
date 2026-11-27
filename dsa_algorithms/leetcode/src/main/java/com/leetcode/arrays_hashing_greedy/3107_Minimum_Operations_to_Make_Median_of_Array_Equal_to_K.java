package com.leetcode.arrays_hashing_greedy;

class Solution3107 {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = n >> 1;
        long ans = Math.abs(nums[m] - k);
        if (nums[m] > k) {
            for (int i = m - 1; i >= 0 && nums[i] > k; --i) {
                ans += nums[i] - k;
            }
        } else {
            for (int i = m + 1; i < n && nums[i] < k; ++i) {
                ans += k - nums[i];
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
        Solution3107 _tcSol = new Solution3107();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,6,8,5], k = 4");
        try {
            int[] nums = new int[]{2, 5, 6, 8, 5};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsToMakeMedianK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,5,6,8,5], k = 7");
        try {
            int[] nums = new int[]{2, 5, 6, 8, 5};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsToMakeMedianK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6], k = 4");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperationsToMakeMedianK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}