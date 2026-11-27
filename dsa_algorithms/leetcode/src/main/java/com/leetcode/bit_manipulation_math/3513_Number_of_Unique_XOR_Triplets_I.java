package com.leetcode.bit_manipulation_math;

class Solution3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        return n <= 2 ? n : 1 << (32 - Integer.numberOfLeadingZeros(n));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3513 _tcSol = new Solution3513();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2]");
        try {
            int[] nums = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueXorTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,2]");
        try {
            int[] nums = new int[]{3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueXorTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}