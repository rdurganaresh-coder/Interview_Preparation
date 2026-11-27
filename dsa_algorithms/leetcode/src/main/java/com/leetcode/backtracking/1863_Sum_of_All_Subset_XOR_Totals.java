package com.leetcode.backtracking;

class Solution1863 {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 1 << n; ++i) {
            int s = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    s ^= nums[j];
                }
            }
            ans += s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1863 _tcSol = new Solution1863();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3]");
        try {
            int[] nums = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetXORSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,1,6]");
        try {
            int[] nums = new int[]{5, 1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetXORSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,4,5,6,7,8]");
        try {
            int[] nums = new int[]{3, 4, 5, 6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetXORSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "480");
        System.out.println();
    }
}