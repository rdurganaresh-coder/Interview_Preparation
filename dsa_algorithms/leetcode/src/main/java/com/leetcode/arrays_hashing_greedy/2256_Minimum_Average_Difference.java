package com.leetcode.arrays_hashing_greedy;

class Solution2256 {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long pre = 0, suf = 0;
        for (int x : nums) {
            suf += x;
        }
        int ans = 0;
        long mi = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            pre += nums[i];
            suf -= nums[i];
            long a = pre / (i + 1);
            long b = n - i - 1 == 0 ? 0 : suf / (n - i - 1);
            long t = Math.abs(a - b);
            if (t < mi) {
                ans = i;
                mi = t;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2256 _tcSol = new Solution2256();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,3,9,5,3]");
        try {
            int[] nums = new int[]{2, 5, 3, 9, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAverageDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0]");
        try {
            int[] nums = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAverageDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}