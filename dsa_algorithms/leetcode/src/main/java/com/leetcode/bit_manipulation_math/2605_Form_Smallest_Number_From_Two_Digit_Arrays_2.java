package com.leetcode.bit_manipulation_math;

class Solution2605_2 {
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] s1 = new boolean[10];
        boolean[] s2 = new boolean[10];
        for (int x : nums1) {
            s1[x] = true;
        }
        for (int x : nums2) {
            s2[x] = true;
        }
        int a = 0, b = 0;
        for (int i = 1; i < 10; ++i) {
            if (s1[i] && s2[i]) {
                return i;
            }
            if (a == 0 && s1[i]) {
                a = i;
            }
            if (b == 0 && s2[i]) {
                b = i;
            }
        }
        return Math.min(a * 10 + b, b * 10 + a);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2605_2 _tcSol = new Solution2605_2();
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