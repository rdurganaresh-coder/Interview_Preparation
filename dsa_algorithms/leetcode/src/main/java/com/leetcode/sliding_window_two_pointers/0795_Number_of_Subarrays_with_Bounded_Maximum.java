package com.leetcode.sliding_window_two_pointers;

class Solution0795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return f(nums, right) - f(nums, left - 1);
    }

    private int f(int[] nums, int x) {
        int cnt = 0, t = 0;
        for (int v : nums) {
            t = v > x ? 0 : t + 1;
            cnt += t;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0795 _tcSol = new Solution0795();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,4,3], left = 2, right = 3");
        try {
            int[] nums = new int[]{2, 1, 4, 3};
            int left = 2;
            int right = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarrayBoundedMax(nums, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,9,2,5,6], left = 2, right = 8");
        try {
            int[] nums = new int[]{2, 9, 2, 5, 6};
            int left = 2;
            int right = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarrayBoundedMax(nums, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}