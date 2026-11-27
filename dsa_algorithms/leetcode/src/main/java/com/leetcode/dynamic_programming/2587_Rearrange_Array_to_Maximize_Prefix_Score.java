package com.leetcode.dynamic_programming;

class Solution2587 {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long s = 0;
        for (int i = 0; i < n; ++i) {
            s += nums[n - i - 1];
            if (s <= 0) {
                return i;
            }
        }
        return n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2587 _tcSol = new Solution2587();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,-1,0,1,-3,3,-3]");
        try {
            int[] nums = new int[]{2, -1, 0, 1, -3, 3, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-2,-3,0]");
        try {
            int[] nums = new int[]{-2, -3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}