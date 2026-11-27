package com.leetcode.arrays_hashing_greedy;

class Solution2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0;
        boolean hasZero = false;
        for (int x : nums1) {
            hasZero |= x == 0;
            s1 += Math.max(x, 1);
        }
        for (int x : nums2) {
            s2 += Math.max(x, 1);
        }
        if (s1 > s2) {
            return minSum(nums2, nums1);
        }
        if (s1 == s2) {
            return s1;
        }
        return hasZero ? s2 : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2918 _tcSol = new Solution2918();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [3,2,0,1,0], nums2 = [6,5,0]");
        try {
            int[] nums1 = new int[]{3, 2, 0, 1, 0};
            int[] nums2 = new int[]{6, 5, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,0,2,0], nums2 = [1,4]");
        try {
            int[] nums1 = new int[]{2, 0, 2, 0};
            int[] nums2 = new int[]{1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}