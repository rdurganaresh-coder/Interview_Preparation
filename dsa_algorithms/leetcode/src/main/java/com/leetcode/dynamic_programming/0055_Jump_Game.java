package com.leetcode.dynamic_programming;

class Solution0055 {
    public boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (mx < i) {
                return false;
            }
            mx = Math.max(mx, i + nums[i]);
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0055 _tcSol = new Solution0055();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,1,1,4]");
        try {
            int[] nums = new int[]{2, 3, 1, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.canJump(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,1,0,4]");
        try {
            int[] nums = new int[]{3, 2, 1, 0, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.canJump(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}