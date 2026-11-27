package com.leetcode.arrays_hashing_greedy;

class Solution2680 {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] suf = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            suf[i] = suf[i + 1] | nums[i];
        }
        long ans = 0, pre = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, pre | (1L * nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2680 _tcSol = new Solution2680();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [12,9], k = 1");
        try {
            int[] nums = new int[]{12, 9};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumOr(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [8,1,2], k = 2");
        try {
            int[] nums = new int[]{8, 1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumOr(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();
    }
}