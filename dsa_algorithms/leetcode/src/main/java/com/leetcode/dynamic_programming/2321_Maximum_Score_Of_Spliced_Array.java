package com.leetcode.dynamic_programming;

class Solution2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int s1 = 0, s2 = 0, n = nums1.length;
        for (int i = 0; i < n; ++i) {
            s1 += nums1[i];
            s2 += nums2[i];
        }
        return Math.max(s2 + f(nums1, nums2), s1 + f(nums2, nums1));
    }

    private int f(int[] nums1, int[] nums2) {
        int t = nums1[0] - nums2[0];
        int mx = t;
        for (int i = 1; i < nums1.length; ++i) {
            int v = nums1[i] - nums2[i];
            if (t > 0) {
                t += v;
            } else {
                t = v;
            }
            mx = Math.max(mx, t);
        }
        return mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2321 _tcSol = new Solution2321();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [60,60,60], nums2 = [10,90,10]");
        try {
            int[] nums1 = new int[]{60, 60, 60};
            int[] nums2 = new int[]{10, 90, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumsSplicedArray(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "210");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [20,40,20,70,30], nums2 = [50,20,50,40,20]");
        try {
            int[] nums1 = new int[]{20, 40, 20, 70, 30};
            int[] nums2 = new int[]{50, 20, 50, 40, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumsSplicedArray(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "220");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [7,11,13], nums2 = [1,1,1]");
        try {
            int[] nums1 = new int[]{7, 11, 13};
            int[] nums2 = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumsSplicedArray(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "31");
        System.out.println();
    }
}