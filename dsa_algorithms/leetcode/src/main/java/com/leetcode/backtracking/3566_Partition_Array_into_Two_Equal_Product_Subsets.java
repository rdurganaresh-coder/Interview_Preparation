package com.leetcode.backtracking;

class Solution3566 {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
        for (int i = 0; i < 1 << n; ++i) {
            long x = 1, y = 1;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    x *= nums[j];
                } else {
                    y *= nums[j];
                }
            }
            if (x == target && y == target) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3566 _tcSol = new Solution3566();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,6,8,4], target = 24");
        try {
            int[] nums = new int[]{3, 1, 6, 8, 4};
            long target = 24L;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkEqualPartitions(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,5,3,7], target = 15");
        try {
            int[] nums = new int[]{2, 5, 3, 7};
            long target = 15L;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkEqualPartitions(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}