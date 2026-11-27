package com.leetcode.sliding_window_two_pointers;

class Solution1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] == 1) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] == 1) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, left[i] + right[i + 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1493 _tcSol = new Solution1493();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,0,1]");
        try {
            int[] nums = new int[]{1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,1,1,0,1,1,0,1]");
        try {
            int[] nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}