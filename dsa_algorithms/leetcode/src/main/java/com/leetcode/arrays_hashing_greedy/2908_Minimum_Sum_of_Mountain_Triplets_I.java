package com.leetcode.arrays_hashing_greedy;

class Solution2908 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] right = new int[n + 1];
        final int inf = 1 << 30;
        right[n] = inf;
        for (int i = n - 1; i >= 0; --i) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int ans = inf, left = inf;
        for (int i = 0; i < n; ++i) {
            if (left < nums[i] && right[i + 1] < nums[i]) {
                ans = Math.min(ans, left + nums[i] + right[i + 1]);
            }
            left = Math.min(left, nums[i]);
        }
        return ans == inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2908 _tcSol = new Solution2908();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,6,1,5,3]");
        try {
            int[] nums = new int[]{8, 6, 1, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,4,8,7,10,2]");
        try {
            int[] nums = new int[]{5, 4, 8, 7, 10, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [6,5,4,3,4,5]");
        try {
            int[] nums = new int[]{6, 5, 4, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}