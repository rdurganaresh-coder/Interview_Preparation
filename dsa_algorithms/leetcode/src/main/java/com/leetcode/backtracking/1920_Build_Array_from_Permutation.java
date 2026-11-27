package com.leetcode.backtracking;

class Solution1920 {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1920 _tcSol = new Solution1920();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,2,1,5,3,4]");
        try {
            int[] nums = new int[]{0, 2, 1, 5, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.buildArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,4,5,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,0,1,2,3,4]");
        try {
            int[] nums = new int[]{5, 0, 1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.buildArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5,0,1,2,3]");
        System.out.println();
    }
}