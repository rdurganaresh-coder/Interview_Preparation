package com.leetcode.matrices_grids;

class Solution3024 {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3024 _tcSol = new Solution3024();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,3,3]");
        try {
            int[] nums = new int[]{3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.triangleType(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"equilateral\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,5]");
        try {
            int[] nums = new int[]{3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.triangleType(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"scalene\"");
        System.out.println();
    }
}