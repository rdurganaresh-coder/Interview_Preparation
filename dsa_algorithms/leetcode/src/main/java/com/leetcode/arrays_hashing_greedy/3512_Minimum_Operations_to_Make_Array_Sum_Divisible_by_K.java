package com.leetcode.arrays_hashing_greedy;

class Solution3512 {
    public int minOperations(int[] nums, int k) {
        return Arrays.stream(nums).sum() % k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3512 _tcSol = new Solution3512();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,9,7], k = 5");
        try {
            int[] nums = new int[]{3, 9, 7};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,1,3], k = 4");
        try {
            int[] nums = new int[]{4, 1, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2], k = 6");
        try {
            int[] nums = new int[]{3, 2};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}