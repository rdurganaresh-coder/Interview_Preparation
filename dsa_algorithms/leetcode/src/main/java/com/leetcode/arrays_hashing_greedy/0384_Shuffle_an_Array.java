package com.leetcode.arrays_hashing_greedy;

class Solution0384 {
    private int[] nums;
    private int[] original;
    private Random rand;

    public Solution0384(int[] nums) {
        this.nums = nums;
        this.original = Arrays.copyOf(nums, nums.length);
        this.rand = new Random();
    }

    public int[] reset() {
        nums = Arrays.copyOf(original, original.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; ++i) {
            swap(i, i + rand.nextInt(nums.length - i));
        }
        return nums;
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

/**
 * Your Solution0384 object will be instantiated and called as such:
 * Solution0384 obj = new Solution0384(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */