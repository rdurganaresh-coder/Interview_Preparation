package com.leetcode.arrays_hashing_greedy;

class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int i = 0; i < n >> 1; ++i) {
            ans = Math.max(ans, nums[i] + nums[n - i - 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1877 _tcSol = new Solution1877();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,2,3]");
        try {
            int[] nums = new int[]{3, 5, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPairSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,5,4,2,4,6]");
        try {
            int[] nums = new int[]{3, 5, 4, 2, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minPairSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}