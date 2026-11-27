package com.leetcode.arrays_hashing_greedy;

class Solution2176 {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int j = 1; j < nums.length; ++j) {
            for (int i = 0; i < j; ++i) {
                ans += nums[i] == nums[j] && (i * j % k) == 0 ? 1 : 0;
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
        Solution2176 _tcSol = new Solution2176();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,2,2,2,1,3], k = 2");
        try {
            int[] nums = new int[]{3, 1, 2, 2, 2, 1, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4], k = 1");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
