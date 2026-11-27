package com.leetcode.backtracking;

class Solution0377 {
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int x : nums) {
                if (i >= x) {
                    f[i] += f[i - x];
                }
            }
        }
        return f[target];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0377 _tcSol = new Solution0377();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], target = 4");
        try {
            int[] nums = new int[]{1, 2, 3};
            int target = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum4(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9], target = 3");
        try {
            int[] nums = new int[]{9};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum4(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}