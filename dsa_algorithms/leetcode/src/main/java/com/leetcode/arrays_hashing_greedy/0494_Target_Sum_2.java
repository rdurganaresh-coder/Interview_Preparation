package com.leetcode.arrays_hashing_greedy;

class Solution0494_2 {
    public int findTargetSumWays(int[] nums, int target) {
        int s = Arrays.stream(nums).sum();
        if (s < target || (s - target) % 2 != 0) {
            return 0;
        }
        int n = (s - target) / 2;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int num : nums) {
            for (int j = n; j >= num; --j) {
                f[j] += f[j - num];
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0494_2 _tcSol = new Solution0494_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1], target = 3");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTargetSumWays(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1], target = 1");
        try {
            int[] nums = new int[]{1};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTargetSumWays(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}