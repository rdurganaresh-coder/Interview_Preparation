package com.leetcode.arrays_hashing_greedy;

class NumArray0303 {
    private int[] s;

    public NumArray0303(int[] nums) {
        int n = nums.length;
        s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}

/**
 * Your NumArray0303 object will be instantiated and called as such:
 * NumArray0303 obj = new NumArray0303(nums);
 * int param_1 = obj.sumRange(left,right);
 */