package com.leetcode.bit_manipulation_math;

class Solution2997 {
    public int minOperations(int[] nums, int k) {
        for (int x : nums) {
            k ^= x;
        }
        return Integer.bitCount(k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2997 _tcSol = new Solution2997();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,4], k = 1");
        try {
            int[] nums = new int[]{2, 1, 3, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,0,2,0], k = 0");
        try {
            int[] nums = new int[]{2, 0, 2, 0};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}