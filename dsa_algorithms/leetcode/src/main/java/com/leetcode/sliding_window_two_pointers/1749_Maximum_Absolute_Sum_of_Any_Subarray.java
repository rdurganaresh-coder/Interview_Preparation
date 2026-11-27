package com.leetcode.sliding_window_two_pointers;

class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        int f = 0, g = 0;
        int ans = 0;
        for (int x : nums) {
            f = Math.max(f, 0) + x;
            g = Math.min(g, 0) + x;
            ans = Math.max(ans, Math.max(f, Math.abs(g)));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1749 _tcSol = new Solution1749();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-3,2,3,-4]");
        try {
            int[] nums = new int[]{1, -3, 2, 3, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAbsoluteSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,-5,1,-4,3,-2]");
        try {
            int[] nums = new int[]{2, -5, 1, -4, 3, -2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAbsoluteSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}