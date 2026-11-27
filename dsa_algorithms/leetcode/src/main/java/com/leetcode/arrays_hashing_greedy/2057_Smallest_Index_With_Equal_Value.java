package com.leetcode.arrays_hashing_greedy;

class Solution2057 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2057 _tcSol = new Solution2057();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2]");
        try {
            int[] nums = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestEqual(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,2,1]");
        try {
            int[] nums = new int[]{4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestEqual(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6,7,8,9,0]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestEqual(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}