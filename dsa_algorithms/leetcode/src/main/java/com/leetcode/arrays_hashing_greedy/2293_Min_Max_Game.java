package com.leetcode.arrays_hashing_greedy;

class Solution2293 {
    public int minMaxGame(int[] nums) {
        for (int n = nums.length; n > 1;) {
            n >>= 1;
            for (int i = 0; i < n; ++i) {
                int a = nums[i << 1], b = nums[i << 1 | 1];
                nums[i] = i % 2 == 0 ? Math.min(a, b) : Math.max(a, b);
            }
        }
        return nums[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2293 _tcSol = new Solution2293();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,2,4,8,2,2]");
        try {
            int[] nums = new int[]{1, 3, 5, 2, 4, 8, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMaxGame(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3]");
        try {
            int[] nums = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMaxGame(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}