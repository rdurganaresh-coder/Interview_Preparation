package com.leetcode.arrays_hashing_greedy;

class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        final int inf = 1 << 30;
        int[][] f = new int[n + 1][3];
        f[0][1] = f[0][2] = -inf;
        for (int i = 1; i <= n; ++i) {
            int x = nums[i - 1];
            for (int j = 0; j < 3; ++j) {
                f[i][j] = Math.max(f[i - 1][j], f[i - 1][(j - x % 3 + 3) % 3] + x);
            }
        }
        return f[n][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1262 _tcSol = new Solution1262();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,6,5,1,8]");
        try {
            int[] nums = new int[]{3, 6, 5, 1, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDivThree(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4]");
        try {
            int[] nums = new int[]{4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDivThree(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDivThree(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}