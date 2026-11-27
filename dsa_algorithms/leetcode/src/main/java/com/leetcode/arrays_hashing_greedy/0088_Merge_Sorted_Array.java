package com.leetcode.arrays_hashing_greedy;

class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; j >= 0; --k) {
            nums1[k] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0088 _tcSol = new Solution0088();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3");
        try {
            int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
            int m = 3;
            int[] nums2 = new int[]{2, 5, 6};
            int n = 3;
            _tcSol.merge(nums1, m, nums2, n);
            System.out.println("  Output  : " + _tcShow(nums1));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2,3,5,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1], m = 1, nums2 = [], n = 0");
        try {
            int[] nums1 = new int[]{1};
            int m = 1;
            int[] nums2 = new int[]{};
            int n = 0;
            _tcSol.merge(nums1, m, nums2, n);
            System.out.println("  Output  : " + _tcShow(nums1));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [0], m = 0, nums2 = [1], n = 1");
        try {
            int[] nums1 = new int[]{0};
            int m = 0;
            int[] nums2 = new int[]{1};
            int n = 1;
            _tcSol.merge(nums1, m, nums2, n);
            System.out.println("  Output  : " + _tcShow(nums1));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();
    }
}