package com.leetcode.arrays_hashing_greedy;

class Solution0075 {
    public void sortColors(int[] nums) {
        int i = -1, j = nums.length, k = 0;
        while (k < j) {
            if (nums[k] == 0) {
                swap(nums, ++i, k++);
            } else if (nums[k] == 2) {
                swap(nums, --j, k);
            } else {
                ++k;
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
        Solution0075 _tcSol = new Solution0075();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,0,2,1,1,0]");
        try {
            int[] nums = new int[]{2, 0, 2, 1, 1, 0};
            _tcSol.sortColors(nums);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,1,1,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,0,1]");
        try {
            int[] nums = new int[]{2, 0, 1};
            _tcSol.sortColors(nums);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2]");
        System.out.println();
    }
}