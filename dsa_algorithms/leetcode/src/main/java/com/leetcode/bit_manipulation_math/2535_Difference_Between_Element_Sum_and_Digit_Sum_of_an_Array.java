package com.leetcode.bit_manipulation_math;

class Solution2535 {
    public int differenceOfSum(int[] nums) {
        int x = 0, y = 0;
        for (int v : nums) {
            x += v;
            for (; v > 0; v /= 10) {
                y += v % 10;
            }
        }
        return x - y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2535 _tcSol = new Solution2535();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,15,6,3]");
        try {
            int[] nums = new int[]{1, 15, 6, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.differenceOfSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.differenceOfSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
