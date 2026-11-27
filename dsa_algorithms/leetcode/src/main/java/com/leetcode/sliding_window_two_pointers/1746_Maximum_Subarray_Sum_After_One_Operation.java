package com.leetcode.sliding_window_two_pointers;

class Solution1746 {
    public int maxSumAfterOperation(int[] nums) {
        int f = 0, g = 0;
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            int ff = Math.max(f, 0) + x;
            int gg = Math.max(Math.max(f, 0) + x * x, g + x);
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1746 _tcSol = new Solution1746();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,-1,-4,-3]");
        try {
            int[] nums = new int[]{2, -1, -4, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumAfterOperation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-1,1,1,-1,-1,1]");
        try {
            int[] nums = new int[]{1, -1, 1, 1, -1, -1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumAfterOperation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}