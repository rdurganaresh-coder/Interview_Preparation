package com.leetcode.sliding_window_two_pointers;

class Solution1852_2 {
    public int[] distinctNumbers(int[] nums, int k) {
        int m = 0;
        for (int x : nums) {
            m = Math.max(m, x);
        }
        int[] cnt = new int[m + 1];
        int v = 0;
        for (int i = 0; i < k; ++i) {
            if (++cnt[nums[i]] == 1) {
                ++v;
            }
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = v;
        for (int i = k; i < n; ++i) {
            if (++cnt[nums[i]] == 1) {
                ++v;
            }
            if (--cnt[nums[i - k]] == 0) {
                --v;
            }
            ans[i - k + 1] = v;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1852_2 _tcSol = new Solution1852_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,2,2,1,3], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 2, 2, 1, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctNumbers(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,2,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1,2,3,4], k = 4");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 2, 3, 4};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctNumbers(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4]");
        System.out.println();
    }
}