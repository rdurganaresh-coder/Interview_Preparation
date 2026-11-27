package com.leetcode.arrays_hashing_greedy;

class Solution1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < m; ++i) {
            int left = i, right = n - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (nums2[mid] >= nums1[i]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            ans = Math.max(ans, left - i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1855 _tcSol = new Solution1855();
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