package com.leetcode.arrays_hashing_greedy;

class Solution1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int mod = (int) 1e9 + 7;
        int[] nums = nums1.clone();
        Arrays.sort(nums);
        int s = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            s = (s + Math.abs(nums1[i] - nums2[i])) % mod;
        }
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            int d1 = Math.abs(nums1[i] - nums2[i]);
            int d2 = 1 << 30;
            int j = search(nums, nums2[i]);
            if (j < n) {
                d2 = Math.min(d2, Math.abs(nums[j] - nums2[i]));
            }
            if (j > 0) {
                d2 = Math.min(d2, Math.abs(nums[j - 1] - nums2[i]));
            }
            mx = Math.max(mx, d1 - d2);
        }
        return (s - mx + mod) % mod;
    }

    private int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1818 _tcSol = new Solution1818();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,7,5], nums2 = [2,3,5]");
        try {
            int[] nums1 = new int[]{1, 7, 5};
            int[] nums2 = new int[]{2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsoluteSumDiff(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]");
        try {
            int[] nums1 = new int[]{2, 4, 6, 8, 10};
            int[] nums2 = new int[]{2, 4, 6, 8, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsoluteSumDiff(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]");
        try {
            int[] nums1 = new int[]{1, 10, 4, 4, 2, 7};
            int[] nums2 = new int[]{9, 3, 5, 1, 7, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsoluteSumDiff(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}