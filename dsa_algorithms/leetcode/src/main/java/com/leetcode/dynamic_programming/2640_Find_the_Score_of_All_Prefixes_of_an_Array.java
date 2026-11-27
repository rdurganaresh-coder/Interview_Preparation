package com.leetcode.dynamic_programming;

class Solution2640 {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            mx = Math.max(mx, nums[i]);
            ans[i] = nums[i] + mx + (i == 0 ? 0 : ans[i - 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2640 _tcSol = new Solution2640();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,7,5,10]");
        try {
            int[] nums = new int[]{2, 3, 7, 5, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPrefixScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,10,24,36,56]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2,4,8,16]");
        try {
            int[] nums = new int[]{1, 1, 2, 4, 8, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPrefixScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,8,16,32,64]");
        System.out.println();
    }
}