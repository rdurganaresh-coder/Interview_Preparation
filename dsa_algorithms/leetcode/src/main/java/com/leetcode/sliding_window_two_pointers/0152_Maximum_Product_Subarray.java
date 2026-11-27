package com.leetcode.sliding_window_two_pointers;

class Solution0152 {
    public int maxProduct(int[] nums) {
        int f = nums[0], g = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int ff = f, gg = g;
            f = Math.max(nums[i], Math.max(ff * nums[i], gg * nums[i]));
            g = Math.min(nums[i], Math.min(ff * nums[i], gg * nums[i]));
            ans = Math.max(ans, f);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0152 _tcSol = new Solution0152();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,-2,4]");
        try {
            int[] nums = new int[]{2, 3, -2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-2,0,-1]");
        try {
            int[] nums = new int[]{-2, 0, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}