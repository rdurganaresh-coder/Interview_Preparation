package com.leetcode.dynamic_programming;

class Solution3584 {
    public long maximumProduct(int[] nums, int m) {
        long ans = Long.MIN_VALUE;
        int mx = Integer.MIN_VALUE;
        int mi = Integer.MAX_VALUE;
        for (int i = m - 1; i < nums.length; ++i) {
            int x = nums[i];
            int y = nums[i - m + 1];
            mi = Math.min(mi, y);
            mx = Math.max(mx, y);
            ans = Math.max(ans, Math.max(1L * x * mi, 1L * x * mx));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3584 _tcSol = new Solution3584();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,-9,2,3,-2,-3,1], m = 1");
        try {
            int[] nums = new int[]{-1, -9, 2, 3, -2, -3, 1};
            int m = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "81");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,-5,5,6,-4], m = 3");
        try {
            int[] nums = new int[]{1, 3, -5, 5, 6, -4};
            int m = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,-1,2,-6,5,2,-5,7], m = 2");
        try {
            int[] nums = new int[]{2, -1, 2, -6, 5, 2, -5, 7};
            int m = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();
    }
}