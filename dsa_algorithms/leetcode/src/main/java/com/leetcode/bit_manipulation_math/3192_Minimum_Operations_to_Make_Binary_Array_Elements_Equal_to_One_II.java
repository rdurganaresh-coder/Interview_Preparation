package com.leetcode.bit_manipulation_math;

class Solution3192 {
    public int minOperations(int[] nums) {
        int ans = 0, v = 0;
        for (int x : nums) {
            x ^= v;
            if (x == 0) {
                v ^= 1;
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
        Solution3192 _tcSol = new Solution3192();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,1,0,1]");
        try {
            int[] nums = new int[]{0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,0,0]");
        try {
            int[] nums = new int[]{1, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}