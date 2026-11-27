package com.leetcode.arrays_hashing_greedy;

class Solution2789 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long ans = nums[n - 1], t = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= t) {
                t += nums[i];
            } else {
                t = nums[i];
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
        Solution2789 _tcSol = new Solution2789();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,7,9,3]");
        try {
            int[] nums = new int[]{2, 3, 7, 9, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArrayValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,3,3]");
        try {
            int[] nums = new int[]{5, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArrayValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}