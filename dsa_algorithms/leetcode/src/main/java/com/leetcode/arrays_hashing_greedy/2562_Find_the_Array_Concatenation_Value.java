package com.leetcode.arrays_hashing_greedy;

class Solution2562 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int i = 0, j = nums.length - 1;
        for (; i < j; ++i, --j) {
            ans += Integer.parseInt(nums[i] + "" + nums[j]);
        }
        if (i == j) {
            ans += nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2562 _tcSol = new Solution2562();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,52,2,4]");
        try {
            int[] nums = new int[]{7, 52, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheArrayConcVal(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "596");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,14,13,8,12]");
        try {
            int[] nums = new int[]{5, 14, 13, 8, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheArrayConcVal(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "673");
        System.out.println();
    }
}