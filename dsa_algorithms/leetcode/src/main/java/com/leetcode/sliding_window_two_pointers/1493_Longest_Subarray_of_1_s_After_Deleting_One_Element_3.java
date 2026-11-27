package com.leetcode.sliding_window_two_pointers;

class Solution1493_3 {
    public int longestSubarray(int[] nums) {
        int cnt = 0, l = 0;
        for (int x : nums) {
            cnt += x ^ 1;
            if (cnt > 1) {
                cnt -= nums[l++] ^ 1;
            }
        }
        return nums.length - l - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1493_3 _tcSol = new Solution1493_3();
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
