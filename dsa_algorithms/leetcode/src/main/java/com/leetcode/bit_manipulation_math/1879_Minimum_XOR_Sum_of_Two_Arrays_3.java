package com.leetcode.bit_manipulation_math;

class Solution1879_3 {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] f = new int[1 << n];
        Arrays.fill(f, 1 << 30);
        f[0] = 0;
        for (int i = 0; i < 1 << n; ++i) {
            int k = Integer.bitCount(i) - 1;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    f[i] = Math.min(f[i], f[i ^ (1 << j)] + (nums1[k] ^ nums2[j]));
                }
            }
        }
        return f[(1 << n) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1879_3 _tcSol = new Solution1879_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2], nums2 = [2,3]");
        try {
            int[] nums1 = new int[]{1, 2};
            int[] nums2 = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumXORSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,0,3], nums2 = [5,3,4]");
        try {
            int[] nums1 = new int[]{1, 0, 3};
            int[] nums2 = new int[]{5, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumXORSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}