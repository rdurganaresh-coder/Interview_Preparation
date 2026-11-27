package com.leetcode.arrays_hashing_greedy;

class Solution1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        // int s = Arrays.stream(nums).sum();
        int s = 0, t = 0;
        for (int x : nums) {
            s += x;
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int v = nums[i] * i - t + s - t - nums[i] * (n - i);
            ans[i] = v;
            t += nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1685 _tcSol = new Solution1685();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,5]");
        try {
            int[] nums = new int[]{2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSumAbsoluteDifferences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,6,8,10]");
        try {
            int[] nums = new int[]{1, 4, 6, 8, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSumAbsoluteDifferences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[24,15,13,15,21]");
        System.out.println();
    }
}