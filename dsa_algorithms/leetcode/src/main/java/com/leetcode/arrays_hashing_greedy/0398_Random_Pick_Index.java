package com.leetcode.arrays_hashing_greedy;

class Solution0398 {
    private int[] nums;
    private Random random = new Random();

    public Solution0398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int n = 0, ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++n;
                int x = 1 + random.nextInt(n);
                if (x == n) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}

/**
 * Your Solution0398 object will be instantiated and called as such:
 * Solution0398 obj = new Solution0398(nums);
 * int param_1 = obj.pick(target);
 */