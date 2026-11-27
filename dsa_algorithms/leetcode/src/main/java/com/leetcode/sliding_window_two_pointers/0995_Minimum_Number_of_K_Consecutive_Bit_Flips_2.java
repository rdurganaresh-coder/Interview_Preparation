package com.leetcode.sliding_window_two_pointers;

class Solution0995_2 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, flipped = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] == -1) {
                flipped ^= 1;
            }
            if (flipped == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                flipped ^= 1;
                ++ans;
                nums[i] = -1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0995_2 _tcSol = new Solution0995_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,0], k = 1");
        try {
            int[] nums = new int[]{0, 1, 0};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minKBitFlips(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,0], k = 2");
        try {
            int[] nums = new int[]{1, 1, 0};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minKBitFlips(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,0,0,1,0,1,1,0], k = 3");
        try {
            int[] nums = new int[]{0, 0, 0, 1, 0, 1, 1, 0};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minKBitFlips(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
