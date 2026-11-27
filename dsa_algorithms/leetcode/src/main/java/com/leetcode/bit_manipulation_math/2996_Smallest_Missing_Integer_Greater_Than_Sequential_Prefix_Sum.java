package com.leetcode.bit_manipulation_math;

class Solution2996 {
    public int missingInteger(int[] nums) {
        int s = nums[0];
        for (int j = 1; j < nums.length && nums[j] == nums[j - 1] + 1; ++j) {
            s += nums[j];
        }
        final int m = 51;
        boolean[] st = new boolean[m];
        for (int x : nums) {
            st[x] = true;
        }
        while (s < m && st[s]) {
            ++s;
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2996 _tcSol = new Solution2996();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,2,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingInteger(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,5,1,12,14,13]");
        try {
            int[] nums = new int[]{3, 4, 5, 1, 12, 14, 13};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingInteger(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}