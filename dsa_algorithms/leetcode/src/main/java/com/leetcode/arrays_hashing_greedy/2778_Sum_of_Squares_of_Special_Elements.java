package com.leetcode.arrays_hashing_greedy;

class Solution2778 {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                ans += nums[i - 1] * nums[i - 1];
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
        Solution2778 _tcSol = new Solution2778();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfSquares(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,7,1,19,18,3]");
        try {
            int[] nums = new int[]{2, 7, 1, 19, 18, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfSquares(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "63");
        System.out.println();
    }
}