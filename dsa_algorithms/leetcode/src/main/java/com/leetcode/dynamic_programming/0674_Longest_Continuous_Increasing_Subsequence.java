package com.leetcode.dynamic_programming;

class Solution0674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        for (int i = 1, cnt = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0674 _tcSol = new Solution0674();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,4,7]");
        try {
            int[] nums = new int[]{1, 3, 5, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLengthOfLCIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,2]");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLengthOfLCIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}