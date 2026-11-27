package com.leetcode.sliding_window_two_pointers;

class Solution2488 {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        for (; nums[i] != k; ++i) {
        }
        int[] cnt = new int[n << 1 | 1];
        int ans = 1;
        int x = 0;
        for (int j = i + 1; j < n; ++j) {
            x += nums[j] > k ? 1 : -1;
            if (x >= 0 && x <= 1) {
                ++ans;
            }
            ++cnt[x + n];
        }
        x = 0;
        for (int j = i - 1; j >= 0; --j) {
            x += nums[j] > k ? 1 : -1;
            if (x >= 0 && x <= 1) {
                ++ans;
            }
            ans += cnt[-x + n] + cnt[-x + 1 + n];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2488 _tcSol = new Solution2488();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,1,4,5], k = 4");
        try {
            int[] nums = new int[]{3, 2, 1, 4, 5};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,1], k = 3");
        try {
            int[] nums = new int[]{2, 3, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}