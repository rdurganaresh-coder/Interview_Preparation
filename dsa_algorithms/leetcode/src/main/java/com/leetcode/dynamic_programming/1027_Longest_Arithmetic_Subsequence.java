package com.leetcode.dynamic_programming;

class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] f = new int[n][1001];
        for (int i = 1; i < n; ++i) {
            for (int k = 0; k < i; ++k) {
                int j = nums[i] - nums[k] + 500;
                f[i][j] = Math.max(f[i][j], f[k][j] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1027 _tcSol = new Solution1027();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3, 6, 9, 12]");
        try {
            int[] nums = new int[]{3, 6, 9, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestArithSeqLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9, 4, 7, 2, 10]");
        try {
            int[] nums = new int[]{9, 4, 7, 2, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestArithSeqLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [20, 1, 15, 3, 10, 5, 8]");
        try {
            int[] nums = new int[]{20, 1, 15, 3, 10, 5, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestArithSeqLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}