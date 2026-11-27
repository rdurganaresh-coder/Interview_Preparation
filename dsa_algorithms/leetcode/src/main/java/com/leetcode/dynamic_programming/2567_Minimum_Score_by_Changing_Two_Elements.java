package com.leetcode.dynamic_programming;

class Solution2567 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 3] - nums[0];
        int b = nums[n - 2] - nums[1];
        int c = nums[n - 1] - nums[2];
        return Math.min(a, Math.min(b, c));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2567 _tcSol = new Solution2567();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,7,8,5]");
        try {
            int[] nums = new int[]{1, 4, 7, 8, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,3]");
        try {
            int[] nums = new int[]{1, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
