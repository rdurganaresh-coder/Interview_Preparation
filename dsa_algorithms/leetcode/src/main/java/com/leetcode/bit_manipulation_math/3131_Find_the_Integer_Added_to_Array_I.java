package com.leetcode.bit_manipulation_math;

class Solution3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3131 _tcSol = new Solution3131();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,6,4], nums2 = [9,7,5]");
        try {
            int[] nums1 = new int[]{2, 6, 4};
            int[] nums2 = new int[]{9, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.addedInteger(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [10], nums2 = [5]");
        try {
            int[] nums1 = new int[]{10};
            int[] nums2 = new int[]{5};
            System.out.println("  Output  : " + _tcShow(_tcSol.addedInteger(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,1,1,1], nums2 = [1,1,1,1]");
        try {
            int[] nums1 = new int[]{1, 1, 1, 1};
            int[] nums2 = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.addedInteger(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}