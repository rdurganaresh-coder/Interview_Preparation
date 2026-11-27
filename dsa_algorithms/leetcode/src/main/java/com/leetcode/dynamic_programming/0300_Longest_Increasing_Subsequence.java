package com.leetcode.dynamic_programming;

class Solution0300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0300 _tcSol = new Solution0300();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,9,2,5,3,7,101,18]");
        try {
            int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0,3,2,3]");
        try {
            int[] nums = new int[]{0, 1, 0, 3, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,7,7,7,7,7,7]");
        try {
            int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}