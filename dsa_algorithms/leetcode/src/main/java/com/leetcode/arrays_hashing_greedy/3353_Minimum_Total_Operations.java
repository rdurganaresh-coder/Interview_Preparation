package com.leetcode.arrays_hashing_greedy;

class Solution3353 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            ans += nums[i] != nums[i - 1] ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3353 _tcSol = new Solution3353();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,2]");
        try {
            int[] nums = new int[]{1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,10,10]");
        try {
            int[] nums = new int[]{10, 10, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
