package com.leetcode.sql_database;

class Solution2892 {
    public int minArrayLength(int[] nums, int k) {
        int ans = 1;
        long y = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int x = nums[i];
            if (x == 0) {
                return 1;
            }
            if (x * y <= k) {
                y *= x;
            } else {
                y = x;
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2892 _tcSol = new Solution2892();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,3,7,3,5], k = 20");
        try {
            int[] nums = new int[]{2, 3, 3, 7, 3, 5};
            int k = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.minArrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,3,3], k = 6");
        try {
            int[] nums = new int[]{3, 3, 3, 3};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minArrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}