package com.leetcode.arrays_hashing_greedy;

class Solution0775 {
    public boolean isIdealPermutation(int[] nums) {
        int mx = 0;
        for (int i = 2; i < nums.length; ++i) {
            mx = Math.max(mx, nums[i - 2]);
            if (mx > nums[i]) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0775 _tcSol = new Solution0775();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,2]");
        try {
            int[] nums = new int[]{1, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isIdealPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,0]");
        try {
            int[] nums = new int[]{1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.isIdealPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}