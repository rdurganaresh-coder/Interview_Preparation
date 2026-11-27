package com.leetcode.dynamic_programming;

class Solution2750 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int ans = 1, j = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                continue;
            }
            if (j > -1) {
                ans = (int) ((long) ans * (i - j) % mod);
            }
            j = i;
        }
        return j == -1 ? 0 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2750 _tcSol = new Solution2750();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,0,0,1]");
        try {
            int[] nums = new int[]{0, 1, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodSubarraySplits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0]");
        try {
            int[] nums = new int[]{0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodSubarraySplits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}