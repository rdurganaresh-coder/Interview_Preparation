package com.leetcode.arrays_hashing_greedy;

class Solution1855_2 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int ans = 0;
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < n && nums1[i] <= nums2[j]) {
                ++j;
            }
            ans = Math.max(ans, j - i - 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1855_2 _tcSol = new Solution1855_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]");
        try {
            int[] nums1 = new int[]{55, 30, 5, 4, 2};
            int[] nums2 = new int[]{100, 20, 10, 10, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,2,2], nums2 = [10,10,1]");
        try {
            int[] nums1 = new int[]{2, 2, 2};
            int[] nums2 = new int[]{10, 10, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]");
        try {
            int[] nums1 = new int[]{30, 29, 19, 5};
            int[] nums2 = new int[]{25, 25, 25, 25, 25};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}