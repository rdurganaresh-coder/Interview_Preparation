package com.leetcode.bit_manipulation_math;

class Solution2529 {
    public int maximumCount(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            if (x > 0) {
                ++a;
            } else if (x < 0) {
                ++b;
            }
        }
        return Math.max(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2529 _tcSol = new Solution2529();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-2,-1,-1,1,2,3]");
        try {
            int[] nums = new int[]{-2, -1, -1, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-3,-2,-1,0,0,1,2]");
        try {
            int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,20,66,1314]");
        try {
            int[] nums = new int[]{5, 20, 66, 1314};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}