package com.leetcode.sliding_window_two_pointers;

class Solution0209_2 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, n = nums.length;
        long s = 0;
        int ans = n + 1;
        for (int r = 0; r < n; ++r) {
            s += nums[r];
            while (s >= target) {
                ans = Math.min(ans, r - l + 1);
                s -= nums[l++];
            }
        }
        return ans > n ? 0 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0209_2 _tcSol = new Solution0209_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = 7, nums = [2,3,1,2,4,3]");
        try {
            int target = 7;
            int[] nums = new int[]{2, 3, 1, 2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubArrayLen(target, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = 4, nums = [1,4,4]");
        try {
            int target = 4;
            int[] nums = new int[]{1, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubArrayLen(target, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = 11, nums = [1,1,1,1,1,1,1,1]");
        try {
            int target = 11;
            int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubArrayLen(target, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
