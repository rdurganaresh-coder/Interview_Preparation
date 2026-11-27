package com.leetcode.sliding_window_two_pointers;

class Solution0992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] left = f(nums, k);
        int[] right = f(nums, k - 1);
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans += right[i] - left[i];
        }
        return ans;
    }

    private int[] f(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int[] pos = new int[n];
        int s = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            if (++cnt[nums[i]] == 1) {
                ++s;
            }
            for (; s > k; ++j) {
                if (--cnt[nums[j]] == 0) {
                    --s;
                }
            }
            pos[i] = j;
        }
        return pos;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0992 _tcSol = new Solution0992();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysWithKDistinct(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,3,4], k = 3");
        try {
            int[] nums = new int[]{1, 2, 1, 3, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysWithKDistinct(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}