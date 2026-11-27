package com.leetcode.arrays_hashing_greedy;

class Solution3576 {
    public boolean canMakeEqual(int[] nums, int k) {
        return check(nums, nums[0], k) || check(nums, -nums[0], k);
    }

    private boolean check(int[] nums, int target, int k) {
        int cnt = 0, sign = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            int x = nums[i] * sign;
            if (x == target) {
                sign = 1;
            } else {
                sign = -1;
                ++cnt;
            }
        }
        return cnt <= k && nums[nums.length - 1] * sign == target;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3576 _tcSol = new Solution3576();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-1,1,-1,1], k = 3");
        try {
            int[] nums = new int[]{1, -1, 1, -1, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeEqual(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-1,-1,1,1,1], k = 5");
        try {
            int[] nums = new int[]{-1, -1, -1, 1, 1, 1};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeEqual(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}