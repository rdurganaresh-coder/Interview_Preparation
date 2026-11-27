package com.leetcode.matrices_grids;

class Solution0976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; --i) {
            int c = nums[i - 1] + nums[i - 2];
            if (c > nums[i]) {
                return c + nums[i];
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0976 _tcSol = new Solution0976();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,2]");
        try {
            int[] nums = new int[]{2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPerimeter(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,10]");
        try {
            int[] nums = new int[]{1, 2, 1, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPerimeter(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}