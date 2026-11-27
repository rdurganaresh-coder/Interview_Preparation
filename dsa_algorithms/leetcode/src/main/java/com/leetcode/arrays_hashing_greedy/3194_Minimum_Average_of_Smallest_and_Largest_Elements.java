package com.leetcode.arrays_hashing_greedy;

class Solution3194 {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1 << 30;
        for (int i = 0; i < n / 2; ++i) {
            ans = Math.min(ans, nums[i] + nums[n - i - 1]);
        }
        return ans / 2.0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3194 _tcSol = new Solution3194();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,8,3,4,15,13,4,1]");
        try {
            int[] nums = new int[]{7, 8, 3, 4, 15, 13, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAverage(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5.5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,9,8,3,10,5]");
        try {
            int[] nums = new int[]{1, 9, 8, 3, 10, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAverage(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5.5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,7,8,9]");
        try {
            int[] nums = new int[]{1, 2, 3, 7, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAverage(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5.0");
        System.out.println();
    }
}