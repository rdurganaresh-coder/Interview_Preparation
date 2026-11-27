package com.leetcode.dynamic_programming;

class Solution3196_3 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] f = new long[n + 1][2];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 2; ++j) {
                f[i][j] = nums[i] + f[i + 1][1];
                if (j == 1) {
                    f[i][j] = Math.max(f[i][j], -nums[i] + f[i + 1][0]);
                }
            }
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3196_3 _tcSol = new Solution3196_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-2,3,4]");
        try {
            int[] nums = new int[]{1, -2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-1,1,-1]");
        try {
            int[] nums = new int[]{1, -1, 1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0]");
        try {
            int[] nums = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "nums = [1,-1]");
        try {
            int[] nums = new int[]{1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
