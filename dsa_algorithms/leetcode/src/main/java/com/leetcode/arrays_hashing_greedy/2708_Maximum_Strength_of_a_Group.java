package com.leetcode.arrays_hashing_greedy;

class Solution2708 {
    public long maxStrength(int[] nums) {
        long ans = (long) -1e14;
        int n = nums.length;
        for (int i = 1; i < 1 << n; ++i) {
            long t = 1;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    t *= nums[j];
                }
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2708 _tcSol = new Solution2708();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,-1,-5,2,5,-9]");
        try {
            int[] nums = new int[]{3, -1, -5, 2, 5, -9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStrength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1350");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-4,-5,-4]");
        try {
            int[] nums = new int[]{-4, -5, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStrength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}