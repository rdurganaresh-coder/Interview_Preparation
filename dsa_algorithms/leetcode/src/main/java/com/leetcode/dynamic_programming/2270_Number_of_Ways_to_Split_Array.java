package com.leetcode.dynamic_programming;

class Solution2270 {
    public int waysToSplitArray(int[] nums) {
        long s = 0;
        for (int x : nums) {
            s += x;
        }
        long t = 0;
        int ans = 0;
        for (int i = 0; i + 1 < nums.length; ++i) {
            t += nums[i];
            ans += t >= s - t ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2270 _tcSol = new Solution2270();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,4,-8,7]");
        try {
            int[] nums = new int[]{10, 4, -8, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToSplitArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,1,0]");
        try {
            int[] nums = new int[]{2, 3, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToSplitArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
