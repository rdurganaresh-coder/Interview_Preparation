package com.leetcode.arrays_hashing_greedy;

class Solution1121_2 {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int cnt = 0;
        int a = 0;
        for (int b : nums) {
            cnt = a == b ? cnt + 1 : 1;
            if (cnt * k > nums.length) {
                return false;
            }
            a = b;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1121_2 _tcSol = new Solution1121_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,3,3,4,4], k = 3");
        try {
            int[] nums = new int[]{1, 2, 2, 3, 3, 4, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canDivideIntoSubsequences(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,6,6,7,8], k = 3");
        try {
            int[] nums = new int[]{5, 6, 6, 7, 8};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canDivideIntoSubsequences(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}