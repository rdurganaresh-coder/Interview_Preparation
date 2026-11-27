package com.leetcode.arrays_hashing_greedy;

class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();
        if (s1 == s2) {
            return 0;
        }
        if (s1 > s2) {
            return minOperations(nums2, nums1);
        }
        int d = s2 - s1;
        int[] arr = new int[nums1.length + nums2.length];
        int k = 0;
        for (int v : nums1) {
            arr[k++] = 6 - v;
        }
        for (int v : nums2) {
            arr[k++] = v - 1;
        }
        Arrays.sort(arr);
        for (int i = 1, j = arr.length - 1; j >= 0; ++i, --j) {
            d -= arr[j];
            if (d <= 0) {
                return i;
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
        Solution1775 _tcSol = new Solution1775();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 4, 5, 6};
            int[] nums2 = new int[]{1, 1, 2, 2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,1,1,1,1,1,1], nums2 = [6]");
        try {
            int[] nums1 = new int[]{1, 1, 1, 1, 1, 1, 1};
            int[] nums2 = new int[]{6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [6,6], nums2 = [1]");
        try {
            int[] nums1 = new int[]{6, 6};
            int[] nums2 = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}