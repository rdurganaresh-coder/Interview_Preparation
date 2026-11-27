package com.leetcode.dynamic_programming;

class Solution0198_2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        f[1] = nums[0];
        for (int i = 2; i <= n; ++i) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0198_2 _tcSol = new Solution0198_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.rob(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,7,9,3,1]");
        try {
            int[] nums = new int[]{2, 7, 9, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.rob(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
