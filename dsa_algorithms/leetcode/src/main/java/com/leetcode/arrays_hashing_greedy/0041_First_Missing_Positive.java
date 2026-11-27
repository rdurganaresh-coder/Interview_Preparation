package com.leetcode.arrays_hashing_greedy;

class Solution0041 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
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
        Solution0041 _tcSol = new Solution0041();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,0]");
        try {
            int[] nums = new int[]{1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstMissingPositive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,-1,1]");
        try {
            int[] nums = new int[]{3, 4, -1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstMissingPositive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,8,9,11,12]");
        try {
            int[] nums = new int[]{7, 8, 9, 11, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstMissingPositive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
