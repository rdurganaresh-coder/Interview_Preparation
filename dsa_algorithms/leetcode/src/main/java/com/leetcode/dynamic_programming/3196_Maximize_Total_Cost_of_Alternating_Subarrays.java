package com.leetcode.dynamic_programming;

class Solution3196 {
    private Long[][] f;
    private int[] nums;
    private int n;

    public long maximumTotalCost(int[] nums) {
        n = nums.length;
        this.nums = nums;
        f = new Long[n][2];
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if (i >= n) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        f[i][j] = nums[i] + dfs(i + 1, 1);
        if (j == 1) {
            f[i][j] = Math.max(f[i][j], -nums[i] + dfs(i + 1, 0));
        }
        return f[i][j];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3196 _tcSol = new Solution3196();
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
