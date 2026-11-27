package com.leetcode.bit_manipulation_math;

class Solution1829_2 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xs = 0;
        for (int x : nums) {
            xs ^= x;
        }
        int mask = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int x = nums[n - i - 1];
            int k = xs ^ mask;
            ans[i] = k;
            xs ^= x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1829_2 _tcSol = new Solution1829_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,1,3], maximumBit = 2");
        try {
            int[] nums = new int[]{0, 1, 1, 3};
            int maximumBit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumXor(nums, maximumBit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,4,7], maximumBit = 3");
        try {
            int[] nums = new int[]{2, 3, 4, 7};
            int maximumBit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumXor(nums, maximumBit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,2,6,5]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,1,2,2,5,7], maximumBit = 3");
        try {
            int[] nums = new int[]{0, 1, 2, 2, 5, 7};
            int maximumBit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumXor(nums, maximumBit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,3,6,4,6,7]");
        System.out.println();
    }
}