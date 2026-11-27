package com.leetcode.dynamic_programming;

class Solution2302_2 {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0, s = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            s += nums[i];
            while (s * (i - j + 1) >= k) {
                s -= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2302_2 _tcSol = new Solution2302_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,4,3,5], k = 10");
        try {
            int[] nums = new int[]{2, 1, 4, 3, 5};
            long k = 10L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1], k = 5");
        try {
            int[] nums = new int[]{1, 1, 1};
            long k = 5L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}