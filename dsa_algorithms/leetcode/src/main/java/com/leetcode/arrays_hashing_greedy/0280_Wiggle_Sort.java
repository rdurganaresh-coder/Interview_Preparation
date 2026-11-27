package com.leetcode.arrays_hashing_greedy;

class Solution0280 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0280 _tcSol = new Solution0280();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,2,1,6,4]");
        try {
            int[] nums = new int[]{3, 5, 2, 1, 6, 4};
            _tcSol.wiggleSort(nums);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,5,1,6,2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,6,5,6,3,8]");
        try {
            int[] nums = new int[]{6, 6, 5, 6, 3, 8};
            _tcSol.wiggleSort(nums);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,6,5,6,3,8]");
        System.out.println();
    }
}