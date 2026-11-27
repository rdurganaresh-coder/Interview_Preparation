package com.leetcode.sliding_window_two_pointers;

class Solution0918 {
    public int maxSubarraySumCircular(int[] nums) {
        final int inf = 1 << 30;
        int pmi = 0, pmx = -inf;
        int ans = -inf, s = 0, smi = inf;
        for (int x : nums) {
            s += x;
            ans = Math.max(ans, s - pmi);
            smi = Math.min(smi, s - pmx);
            pmi = Math.min(pmi, s);
            pmx = Math.max(pmx, s);
        }
        return Math.max(ans, s - smi);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0918 _tcSol = new Solution0918();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-2,3,-2]");
        try {
            int[] nums = new int[]{1, -2, 3, -2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarraySumCircular(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,-3,5]");
        try {
            int[] nums = new int[]{5, -3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarraySumCircular(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-3,-2,-3]");
        try {
            int[] nums = new int[]{-3, -2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarraySumCircular(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-2");
        System.out.println();
    }
}