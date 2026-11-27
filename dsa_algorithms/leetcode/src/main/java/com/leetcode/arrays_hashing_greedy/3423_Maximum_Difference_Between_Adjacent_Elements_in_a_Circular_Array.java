package com.leetcode.arrays_hashing_greedy;

class Solution3423 {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i - 1]));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3423 _tcSol = new Solution3423();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4]");
        try {
            int[] nums = new int[]{1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAdjacentDistance(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-5,-10,-5]");
        try {
            int[] nums = new int[]{-5, -10, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAdjacentDistance(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
