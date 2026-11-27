package com.leetcode.sliding_window_two_pointers;

class Solution2495 {
    public long evenProduct(int[] nums) {
        long ans = 0;
        int last = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                last = i;
            }
            ans += last + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2495 _tcSol = new Solution2495();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [9,6,7,13]");
        try {
            int[] nums = new int[]{9, 6, 7, 13};
            System.out.println("  Output  : " + _tcShow(_tcSol.evenProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,3,5]");
        try {
            int[] nums = new int[]{7, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.evenProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}