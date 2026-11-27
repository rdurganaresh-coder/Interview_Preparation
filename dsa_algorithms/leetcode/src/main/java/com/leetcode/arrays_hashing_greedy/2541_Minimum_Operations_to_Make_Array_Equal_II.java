package com.leetcode.arrays_hashing_greedy;

class Solution2541 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long a = 0, b = 0;
        for (int i = 0; i < nums1.length; ++i) {
            int x = nums1[i], y = nums2[i];
            if (x == y) {
                continue;
            }
            if (k == 0 || (x - y) % k != 0) {
                return -1;
            }
            int t = (x - y) / k;
            if (t < 0) {
                a += -t;
            } else {
                b += t;
            }
        }
        return a == b ? a : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2541 _tcSol = new Solution2541();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [4,3,1,4], nums2 = [1,3,7,1], k = 3");
        try {
            int[] nums1 = new int[]{4, 3, 1, 4};
            int[] nums2 = new int[]{1, 3, 7, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,8,5,2], nums2 = [2,4,1,6], k = 1");
        try {
            int[] nums1 = new int[]{3, 8, 5, 2};
            int[] nums2 = new int[]{2, 4, 1, 6};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
