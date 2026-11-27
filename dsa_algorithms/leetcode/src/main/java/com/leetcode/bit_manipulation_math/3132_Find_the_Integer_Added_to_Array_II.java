package com.leetcode.bit_manipulation_math;

class Solution3132 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 1 << 30;
        for (int i = 0; i < 3; ++i) {
            int x = nums2[0] - nums1[i];
            if (f(nums1, nums2, x)) {
                ans = Math.min(ans, x);
            }
        }
        return ans;
    }

    private boolean f(int[] nums1, int[] nums2, int x) {
        int i = 0, j = 0, cnt = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] - nums1[i] != x) {
                ++cnt;
            } else {
                ++j;
            }
            ++i;
        }
        return cnt <= 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3132 _tcSol = new Solution3132();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [4,20,16,12,8], nums2 = [14,18,10]");
        try {
            int[] nums1 = new int[]{4, 20, 16, 12, 8};
            int[] nums2 = new int[]{14, 18, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAddedInteger(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,5,5,3], nums2 = [7,7]");
        try {
            int[] nums1 = new int[]{3, 5, 5, 3};
            int[] nums2 = new int[]{7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAddedInteger(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}