package com.leetcode.sliding_window_two_pointers;

class Solution1567 {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0] > 0 ? 1 : 0;
        g[0] = nums[0] < 0 ? 1 : 0;
        int ans = f[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > 0) {
                f[i] = f[i - 1] + 1;
                g[i] = g[i - 1] > 0 ? g[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                f[i] = g[i - 1] > 0 ? g[i - 1] + 1 : 0;
                g[i] = f[i - 1] + 1;
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
        Solution1567 _tcSol = new Solution1567();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-2,-3,4]");
        try {
            int[] nums = new int[]{1, -2, -3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxLen(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,-2,-3,-4]");
        try {
            int[] nums = new int[]{0, 1, -2, -3, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxLen(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,0,1]");
        try {
            int[] nums = new int[]{-1, -2, -3, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxLen(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
