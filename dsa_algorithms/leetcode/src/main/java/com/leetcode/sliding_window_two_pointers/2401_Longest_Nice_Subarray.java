package com.leetcode.sliding_window_two_pointers;

class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0, mask = 0;
        for (int l = 0, r = 0; r < nums.length; ++r) {
            while ((mask & nums[r]) != 0) {
                mask ^= nums[l++];
            }
            mask |= nums[r];
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2401 _tcSol = new Solution2401();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,8,48,10]");
        try {
            int[] nums = new int[]{1, 3, 8, 48, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestNiceSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,5,11,13]");
        try {
            int[] nums = new int[]{3, 1, 5, 11, 13};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestNiceSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
