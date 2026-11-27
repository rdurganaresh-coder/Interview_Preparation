package com.leetcode.arrays_hashing_greedy;

class Solution2460 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        int[] ans = new int[n];
        int i = 0;
        for (int x : nums) {
            if (x > 0) {
                ans[i++] = x;
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
        Solution2460 _tcSol = new Solution2460();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,1,1,0]");
        try {
            int[] nums = new int[]{1, 2, 2, 1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.applyOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4,2,0,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1]");
        try {
            int[] nums = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.applyOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();
    }
}