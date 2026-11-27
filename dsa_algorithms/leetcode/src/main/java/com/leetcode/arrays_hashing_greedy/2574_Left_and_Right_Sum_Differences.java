package com.leetcode.arrays_hashing_greedy;

class Solution2574 {
    public int[] leftRightDifference(int[] nums) {
        int l = 0, r = 0;
        for (int x : nums) {
            r += x;
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            r -= nums[i];
            ans[i] = Math.abs(l - r);
            l += nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2574 _tcSol = new Solution2574();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,4,8,3]");
        try {
            int[] nums = new int[]{10, 4, 8, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.leftRightDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[15,1,11,22]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.leftRightDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}
