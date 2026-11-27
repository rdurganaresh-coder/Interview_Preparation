package com.leetcode.bit_manipulation_math;

class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int ans = 100;
        for (int a : nums1) {
            for (int b : nums2) {
                if (a == b) {
                    ans = Math.min(ans, a);
                } else {
                    ans = Math.min(ans, Math.min(a * 10 + b, b * 10 + a));
                }
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
        Solution2605 _tcSol = new Solution2605();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [4,1,3], nums2 = [5,7]");
        try {
            int[] nums1 = new int[]{4, 1, 3};
            int[] nums2 = new int[]{5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumber(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,5,2,6], nums2 = [3,1,7]");
        try {
            int[] nums1 = new int[]{3, 5, 2, 6};
            int[] nums2 = new int[]{3, 1, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumber(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}