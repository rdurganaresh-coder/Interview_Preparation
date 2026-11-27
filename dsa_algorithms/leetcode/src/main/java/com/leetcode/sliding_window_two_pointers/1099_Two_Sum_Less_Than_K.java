package com.leetcode.sliding_window_two_pointers;

class Solution1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = search(nums, k - nums[i], i + 1, n) - 1;
            if (i < j) {
                ans = Math.max(ans, nums[i] + nums[j]);
            }
        }
        return ans;
    }

    private int search(int[] nums, int x, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1099 _tcSol = new Solution1099();
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