package com.leetcode.arrays_hashing_greedy;

class Solution3173 {
    public int[] orArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            ans[i] = nums[i] | nums[i + 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3173 _tcSol = new Solution3173();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,7,15]");
        try {
            int[] nums = new int[]{1, 3, 7, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.orArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,7,15]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [8,4,2]");
        try {
            int[] nums = new int[]{8, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.orArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[12,6]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,4,9,11]");
        try {
            int[] nums = new int[]{5, 4, 9, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.orArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,13,11]");
        System.out.println();
    }
}