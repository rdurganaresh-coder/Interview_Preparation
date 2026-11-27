package com.leetcode.sliding_window_two_pointers;

class Solution0689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int s = 0, s1 = 0, s2 = 0, s3 = 0;
        int mx1 = 0, mx12 = 0;
        int idx1 = 0, idx121 = 0, idx122 = 0;
        for (int i = k * 2; i < nums.length; ++i) {
            s1 += nums[i - k * 2];
            s2 += nums[i - k];
            s3 += nums[i];
            if (i >= k * 3 - 1) {
                if (s1 > mx1) {
                    mx1 = s1;
                    idx1 = i - k * 3 + 1;
                }
                if (mx1 + s2 > mx12) {
                    mx12 = mx1 + s2;
                    idx121 = idx1;
                    idx122 = i - k * 2 + 1;
                }
                if (mx12 + s3 > s) {
                    s = mx12 + s3;
                    ans = new int[] {idx121, idx122, i - k + 1};
                }
                s1 -= nums[i - k * 3 + 1];
                s2 -= nums[i - k * 2 + 1];
                s3 -= nums[i - k + 1];
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
        Solution0689 _tcSol = new Solution0689();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2,6,7,5,1], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 6, 7, 5, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumOfThreeSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2,1,2,1], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumOfThreeSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,4]");
        System.out.println();
    }
}