package com.leetcode.sliding_window_two_pointers;

class Solution2771 {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int f = 1, g = 1;
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            int ff = 1, gg = 1;
            if (nums1[i] >= nums1[i - 1]) {
                ff = Math.max(ff, f + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                ff = Math.max(ff, g + 1);
            }
            if (nums2[i] >= nums1[i - 1]) {
                gg = Math.max(gg, f + 1);
            }
            if (nums2[i] >= nums2[i - 1]) {
                gg = Math.max(gg, g + 1);
            }
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2771 _tcSol = new Solution2771();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,3,1], nums2 = [1,2,1]");
        try {
            int[] nums1 = new int[]{2, 3, 1};
            int[] nums2 = new int[]{1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNonDecreasingLength(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,3,2,1], nums2 = [2,2,3,4]");
        try {
            int[] nums1 = new int[]{1, 3, 2, 1};
            int[] nums2 = new int[]{2, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNonDecreasingLength(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,1], nums2 = [2,2]");
        try {
            int[] nums1 = new int[]{1, 1};
            int[] nums2 = new int[]{2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNonDecreasingLength(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}