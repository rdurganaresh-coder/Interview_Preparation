package com.leetcode.bit_manipulation_math;

class Solution2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if (nums2.length % 2 == 1) {
            for (int v : nums1) {
                ans ^= v;
            }
        }
        if (nums1.length % 2 == 1) {
            for (int v : nums2) {
                ans ^= v;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2425 _tcSol = new Solution2425();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,1,3], nums2 = [10,2,5,0]");
        try {
            int[] nums1 = new int[]{2, 1, 3};
            int[] nums2 = new int[]{10, 2, 5, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.xorAllNums(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2], nums2 = [3,4]");
        try {
            int[] nums1 = new int[]{1, 2};
            int[] nums2 = new int[]{3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.xorAllNums(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}