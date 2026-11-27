package com.leetcode.dynamic_programming;

class Solution2219 {
    public long maximumSumScore(int[] nums) {
        long l = 0, r = 0;
        for (int x : nums) {
            r += x;
        }
        long ans = Long.MIN_VALUE;
        for (int x : nums) {
            l += x;
            ans = Math.max(ans, Math.max(l, r));
            r -= x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2219 _tcSol = new Solution2219();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,-2,5]");
        try {
            int[] nums = new int[]{4, 3, -2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-3,-5]");
        try {
            int[] nums = new int[]{-3, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-3");
        System.out.println();
    }
}
