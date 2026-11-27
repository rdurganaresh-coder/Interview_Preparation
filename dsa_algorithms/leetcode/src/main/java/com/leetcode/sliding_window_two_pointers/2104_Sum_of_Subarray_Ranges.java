package com.leetcode.sliding_window_two_pointers;

class Solution2104 {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int mi = nums[i], mx = nums[i];
            for (int j = i + 1; j < n; ++j) {
                mi = Math.min(mi, nums[j]);
                mx = Math.max(mx, nums[j]);
                ans += (mx - mi);
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
        Solution2104 _tcSol = new Solution2104();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.subArrayRanges(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,3]");
        try {
            int[] nums = new int[]{1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.subArrayRanges(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,-2,-3,4,1]");
        try {
            int[] nums = new int[]{4, -2, -3, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.subArrayRanges(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "59");
        System.out.println();
    }
}