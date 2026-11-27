package com.leetcode.arrays_hashing_greedy;

class Solution1991 {
    public int findMiddleIndex(int[] nums) {
        int l = 0, r = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; ++i) {
            r -= nums[i];
            if (l == r) {
                return i;
            }
            l += nums[i];
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1991 _tcSol = new Solution1991();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,-1,8,4]");
        try {
            int[] nums = new int[]{2, 3, -1, 8, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMiddleIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-1,4]");
        try {
            int[] nums = new int[]{1, -1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMiddleIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,5]");
        try {
            int[] nums = new int[]{2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMiddleIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
