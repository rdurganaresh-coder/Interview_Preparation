package com.leetcode.arrays_hashing_greedy;

class Solution2202 {
    public int maximumTop(int[] nums, int k) {
        if (k == 0) {
            return nums[0];
        }
        int n = nums.length;
        if (n == 1) {
            if (k % 2 == 1) {
                return -1;
            }
            return nums[0];
        }
        int ans = -1;
        for (int i = 0; i < Math.min(k - 1, n); ++i) {
            ans = Math.max(ans, nums[i]);
        }
        if (k < n) {
            ans = Math.max(ans, nums[k]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2202 _tcSol = new Solution2202();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,2,2,4,0,6], k = 4");
        try {
            int[] nums = new int[]{5, 2, 2, 4, 0, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTop(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2], k = 1");
        try {
            int[] nums = new int[]{2};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTop(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}