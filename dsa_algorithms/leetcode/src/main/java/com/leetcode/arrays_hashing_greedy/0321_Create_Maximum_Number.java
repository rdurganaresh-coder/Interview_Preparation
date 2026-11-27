package com.leetcode.arrays_hashing_greedy;

class Solution0321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int l = Math.max(0, k - n), r = Math.min(k, m);
        int[] ans = new int[k];
        for (int x = l; x <= r; ++x) {
            int[] arr1 = f(nums1, x);
            int[] arr2 = f(nums2, k - x);
            int[] arr = merge(arr1, arr2);
            if (compare(arr, ans, 0, 0)) {
                ans = arr;
            }
        }
        return ans;
    }

    private int[] f(int[] nums, int k) {
        int n = nums.length;
        int[] stk = new int[k];
        int top = -1;
        int remain = n - k;
        for (int x : nums) {
            while (top >= 0 && stk[top] < x && remain > 0) {
                --top;
                --remain;
            }
            if (top + 1 < k) {
                stk[++top] = x;
            } else {
                --remain;
            }
        }
        return stk;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        int[] ans = new int[m + n];
        for (int k = 0; k < m + n; ++k) {
            if (compare(nums1, nums2, i, j)) {
                ans[k] = nums1[i++];
            } else {
                ans[k] = nums2[j++];
            }
        }
        return ans;
    }

    private boolean compare(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length) {
            return false;
        }
        if (j >= nums2.length) {
            return true;
        }
        if (nums1[i] > nums2[j]) {
            return true;
        }
        if (nums1[i] < nums2[j]) {
            return false;
        }
        return compare(nums1, nums2, i + 1, j + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0321 _tcSol = new Solution0321();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5");
        try {
            int[] nums1 = new int[]{3, 4, 6, 5};
            int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumber(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,8,6,5,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [6,7], nums2 = [6,0,4], k = 5");
        try {
            int[] nums1 = new int[]{6, 7};
            int[] nums2 = new int[]{6, 0, 4};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumber(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,7,6,0,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [3,9], nums2 = [8,9], k = 3");
        try {
            int[] nums1 = new int[]{3, 9};
            int[] nums2 = new int[]{8, 9};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumber(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,8,9]");
        System.out.println();
    }
}