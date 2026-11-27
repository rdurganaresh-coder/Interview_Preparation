package com.leetcode.dynamic_programming;

class Solution3038 {
    public int maxOperations(int[] nums) {
        int s = nums[0] + nums[1];
        int ans = 0, n = nums.length;
        for (int i = 0; i + 1 < n && nums[i] + nums[i + 1] == s; i += 2) {
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3038 _tcSol = new Solution3038();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,1,4,5]");
        try {
            int[] nums = new int[]{3, 2, 1, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,3,3,4,1,3,2,2,3]");
        try {
            int[] nums = new int[]{1, 5, 3, 3, 4, 1, 3, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,3]");
        try {
            int[] nums = new int[]{5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}