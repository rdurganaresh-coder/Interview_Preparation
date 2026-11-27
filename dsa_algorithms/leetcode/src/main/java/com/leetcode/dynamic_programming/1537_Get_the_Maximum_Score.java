package com.leetcode.dynamic_programming;

class Solution1537 {
    public int maxSum(int[] nums1, int[] nums2) {
        final int mod = (int) 1e9 + 7;
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        long f = 0, g = 0;
        while (i < m || j < n) {
            if (i == m) {
                g += nums2[j++];
            } else if (j == n) {
                f += nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                f += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                g += nums2[j++];
            } else {
                f = g = Math.max(f, g) + nums1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(f, g) % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1537 _tcSol = new Solution1537();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]");
        try {
            int[] nums1 = new int[]{2, 4, 5, 8, 10};
            int[] nums2 = new int[]{4, 6, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,3,5,7,9], nums2 = [3,5,100]");
        try {
            int[] nums1 = new int[]{1, 3, 5, 7, 9};
            int[] nums2 = new int[]{3, 5, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "109");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 4, 5};
            int[] nums2 = new int[]{6, 7, 8, 9, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();
    }
}