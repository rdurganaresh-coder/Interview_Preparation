package com.leetcode.arrays_hashing_greedy;

class Solution3400 {
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans = 0;
        for (int k = 0; k < n; ++k) {
            int t = 0;
            for (int i = 0; i < n; ++i) {
                if (nums1[(i + k) % n] == nums2[i]) {
                    ++t;
                }
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3400 _tcSol = new Solution3400();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [3,1,2,3,1,2], nums2 = [1,2,3,1,2,3]");
        try {
            int[] nums1 = new int[]{3, 1, 2, 3, 1, 2};
            int[] nums2 = new int[]{1, 2, 3, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMatchingIndices(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,4,2,5,3,1], nums2 = [2,3,1,2,4,6]");
        try {
            int[] nums1 = new int[]{1, 4, 2, 5, 3, 1};
            int[] nums2 = new int[]{2, 3, 1, 2, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumMatchingIndices(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
