package com.leetcode.sliding_window_two_pointers;

class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, cnt = 0;
        for (int x : nums) {
            cnt += x ^ 1;
            if (cnt > k) {
                cnt -= nums[l++] ^ 1;
            }
        }
        return nums.length - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1004 _tcSol = new Solution1004();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2");
        try {
            int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestOnes(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3");
        try {
            int[] nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestOnes(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}