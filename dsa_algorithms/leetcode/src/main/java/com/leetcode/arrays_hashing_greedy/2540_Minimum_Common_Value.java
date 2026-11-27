package com.leetcode.arrays_hashing_greedy;

class Solution2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        for (int i = 0, j = 0; i < m && j < n;) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2540 _tcSol = new Solution2540();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3], nums2 = [2,4]");
        try {
            int[] nums1 = new int[]{1, 2, 3};
            int[] nums2 = new int[]{2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getCommon(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2,3,6], nums2 = [2,3,4,5]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 6};
            int[] nums2 = new int[]{2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.getCommon(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}