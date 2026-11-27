package com.leetcode.arrays_hashing_greedy;

class Solution2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] s1 = new int[101];
        int[] s2 = new int[101];
        for (int x : nums1) {
            s1[x] = 1;
        }
        for (int x : nums2) {
            s2[x] = 1;
        }
        int[] ans = new int[2];
        for (int x : nums1) {
            ans[0] += s2[x];
        }
        for (int x : nums2) {
            ans[1] += s1[x];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2956 _tcSol = new Solution2956();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,3,2], nums2 = [1,2]");
        try {
            int[] nums1 = new int[]{2, 3, 2};
            int[] nums2 = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findIntersectionValues(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]");
        try {
            int[] nums1 = new int[]{4, 3, 2, 3, 1};
            int[] nums2 = new int[]{2, 2, 5, 2, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.findIntersectionValues(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [3,4,2,3], nums2 = [1,5]");
        try {
            int[] nums1 = new int[]{3, 4, 2, 3};
            int[] nums2 = new int[]{1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findIntersectionValues(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();
    }
}