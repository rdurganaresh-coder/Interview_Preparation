package com.leetcode.arrays_hashing_greedy;

class Solution2815 {
    public int maxSum(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int v = nums[i] + nums[j];
                if (ans < v && f(nums[i]) == f(nums[j])) {
                    ans = v;
                }
            }
        }
        return ans;
    }

    private int f(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = Math.max(y, x % 10);
        }
        return y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2815 _tcSol = new Solution2815();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [112,131,411]");
        try {
            int[] nums = new int[]{112, 131, 411};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2536,1613,3366,162]");
        try {
            int[] nums = new int[]{2536, 1613, 3366, 162};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5902");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [51,71,17,24,42]");
        try {
            int[] nums = new int[]{51, 71, 17, 24, 42};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "88");
        System.out.println();
    }
}