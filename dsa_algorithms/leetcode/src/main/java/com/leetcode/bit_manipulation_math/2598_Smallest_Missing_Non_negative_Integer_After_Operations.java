package com.leetcode.bit_manipulation_math;

class Solution2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int x : nums) {
            ++cnt[(x % value + value) % value];
        }
        for (int i = 0;; ++i) {
            if (cnt[i % value]-- == 0) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2598 _tcSol = new Solution2598();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-10,7,13,6,8], value = 5");
        try {
            int[] nums = new int[]{1, -10, 7, 13, 6, 8};
            int value = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findSmallestInteger(nums, value)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-10,7,13,6,8], value = 7");
        try {
            int[] nums = new int[]{1, -10, 7, 13, 6, 8};
            int value = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.findSmallestInteger(nums, value)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}