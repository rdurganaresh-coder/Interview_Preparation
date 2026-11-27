package com.leetcode.dynamic_programming;

class Solution3496 {
    public int maxScore(int[] nums) {
        final int inf = 1 << 30;
        int n = nums.length;
        int s = 0, mi = inf;
        int t = inf;
        for (int i = 0; i < n; ++i) {
            s += nums[i];
            mi = Math.min(mi, nums[i]);
            if (i + 1 < n) {
                t = Math.min(t, nums[i] + nums[i + 1]);
            }
        }
        if (n % 2 == 1) {
            return s - mi;
        }
        return s - t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3496 _tcSol = new Solution3496();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,1]");
        try {
            int[] nums = new int[]{2, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,-1,4,2]");
        try {
            int[] nums = new int[]{5, -1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}