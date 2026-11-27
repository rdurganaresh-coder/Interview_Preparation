package com.leetcode.arrays_hashing_greedy;

class Solution0801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int a = 0, b = 1;
        for (int i = 1; i < nums1.length; ++i) {
            int x = a, y = b;
            if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
                a = y;
                b = x + 1;
            } else {
                b = y + 1;
                if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                    a = Math.min(a, y);
                    b = Math.min(b, x + 1);
                }
            }
        }
        return Math.min(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0801 _tcSol = new Solution0801();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,3,5,4], nums2 = [1,2,3,7]");
        try {
            int[] nums1 = new int[]{1, 3, 5, 4};
            int[] nums2 = new int[]{1, 2, 3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwap(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]");
        try {
            int[] nums1 = new int[]{0, 3, 5, 8, 9};
            int[] nums2 = new int[]{2, 1, 4, 6, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwap(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}