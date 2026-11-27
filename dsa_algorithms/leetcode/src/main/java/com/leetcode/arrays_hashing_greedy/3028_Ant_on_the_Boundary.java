package com.leetcode.arrays_hashing_greedy;

class Solution3028 {
    public int returnToBoundaryCount(int[] nums) {
        int ans = 0, s = 0;
        for (int x : nums) {
            s += x;
            if (s == 0) {
                ++ans;
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
        Solution3028 _tcSol = new Solution3028();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,-5]");
        try {
            int[] nums = new int[]{2, 3, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.returnToBoundaryCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,-3,-4]");
        try {
            int[] nums = new int[]{3, 2, -3, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.returnToBoundaryCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}