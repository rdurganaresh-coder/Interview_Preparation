package com.leetcode.arrays_hashing_greedy;

class Solution2934 {
    private int n;

    public int minOperations(int[] nums1, int[] nums2) {
        n = nums1.length;
        int a = f(nums1, nums2, nums1[n - 1], nums2[n - 1]);
        int b = f(nums1, nums2, nums2[n - 1], nums1[n - 1]);
        return a + b == -2 ? -1 : Math.min(a, b + 1);
    }

    private int f(int[] nums1, int[] nums2, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (nums1[i] <= x && nums2[i] <= y) {
                continue;
            }
            if (!(nums1[i] <= y && nums2[i] <= x)) {
                return -1;
            }
            ++cnt;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2934 _tcSol = new Solution2934();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,7], nums2 = [4,5,3]");
        try {
            int[] nums1 = new int[]{1, 2, 7};
            int[] nums2 = new int[]{4, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,3,4,5,9], nums2 = [8,8,4,4,4]");
        try {
            int[] nums1 = new int[]{2, 3, 4, 5, 9};
            int[] nums2 = new int[]{8, 8, 4, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,5,4], nums2 = [2,5,3]");
        try {
            int[] nums1 = new int[]{1, 5, 4};
            int[] nums2 = new int[]{2, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}