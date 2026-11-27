package com.leetcode.dynamic_programming;

class Solution0376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = 1;
        g[0] = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], g[j] + 1);
                } else if (nums[j] > nums[i]) {
                    g[i] = Math.max(g[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, Math.max(f[i], g[i]));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0376 _tcSol = new Solution0376();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,7,4,9,2,5]");
        try {
            int[] nums = new int[]{1, 7, 4, 9, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.wiggleMaxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,17,5,10,13,15,10,5,16,8]");
        try {
            int[] nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.wiggleMaxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6,7,8,9]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.wiggleMaxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}