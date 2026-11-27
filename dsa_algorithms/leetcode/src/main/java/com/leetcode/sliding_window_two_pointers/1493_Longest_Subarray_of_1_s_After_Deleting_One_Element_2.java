package com.leetcode.sliding_window_two_pointers;

class Solution1493_2 {
    public int longestSubarray(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0, j = 0, cnt = 0; i < n; ++i) {
            cnt += nums[i] ^ 1;
            while (cnt > 1) {
                cnt -= nums[j++] ^ 1;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1493_2 _tcSol = new Solution1493_2();
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