package com.leetcode.dynamic_programming;

class Solution2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[i] - nums[j]);
        Arrays.sort(idx, n - k, n);
        int[] ans = new int[k];
        for (int i = n - k; i < n; ++i) {
            ans[i - (n - k)] = nums[idx[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2099 _tcSol = new Solution2099();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,3], k = 2");
        try {
            int[] nums = new int[]{2, 1, 3, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubsequence(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,3,4], k = 3");
        try {
            int[] nums = new int[]{-1, -2, 3, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubsequence(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,3,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,4,3,3], k = 2");
        try {
            int[] nums = new int[]{3, 4, 3, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubsequence(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();
    }
}