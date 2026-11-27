package com.leetcode.sliding_window_two_pointers;

class Solution1708 {
    public int[] largestSubarray(int[] nums, int k) {
        int j = 0;
        for (int i = 1; i < nums.length - k + 1; ++i) {
            if (nums[j] < nums[i]) {
                j = i;
            }
        }
        return Arrays.copyOfRange(nums, j, j + k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1708 _tcSol = new Solution1708();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,5,2,3], k = 3");
        try {
            int[] nums = new int[]{1, 4, 5, 2, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,5,2,3], k = 4");
        try {
            int[] nums = new int[]{1, 4, 5, 2, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5,2,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,4,5,2,3], k = 1");
        try {
            int[] nums = new int[]{1, 4, 5, 2, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5]");
        System.out.println();
    }
}