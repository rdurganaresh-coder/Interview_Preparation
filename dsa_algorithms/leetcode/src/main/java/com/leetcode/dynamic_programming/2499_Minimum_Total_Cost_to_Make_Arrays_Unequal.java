package com.leetcode.dynamic_programming;

class Solution2499 {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        long ans = 0;
        int same = 0;
        int n = nums1.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (nums1[i] == nums2[i]) {
                ans += i;
                ++same;
                ++cnt[nums1[i]];
            }
        }
        int m = 0, lead = 0;
        for (int i = 0; i < cnt.length; ++i) {
            int t = cnt[i] * 2 - same;
            if (t > 0) {
                m = t;
                lead = i;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (m > 0 && nums1[i] != nums2[i] && nums1[i] != lead && nums2[i] != lead) {
                ans += i;
                --m;
            }
        }
        return m > 0 ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2499 _tcSol = new Solution2499();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3,4,5], nums2 = [1,2,3,4,5]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 4, 5};
            int[] nums2 = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalCost(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,2,2,1,3], nums2 = [1,2,2,3,3]");
        try {
            int[] nums1 = new int[]{2, 2, 2, 1, 3};
            int[] nums2 = new int[]{1, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalCost(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,2,2], nums2 = [1,2,2]");
        try {
            int[] nums1 = new int[]{1, 2, 2};
            int[] nums2 = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalCost(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}