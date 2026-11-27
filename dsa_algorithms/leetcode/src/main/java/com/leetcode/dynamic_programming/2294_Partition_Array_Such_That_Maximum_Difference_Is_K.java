package com.leetcode.dynamic_programming;

class Solution2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, a = nums[0];
        for (int b : nums) {
            if (b - a > k) {
                a = b;
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
        Solution2294 _tcSol = new Solution2294();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,6,1,2,5], k = 2");
        try {
            int[] nums = new int[]{3, 6, 1, 2, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 1");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,2,4,5], k = 0");
        try {
            int[] nums = new int[]{2, 2, 4, 5};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}