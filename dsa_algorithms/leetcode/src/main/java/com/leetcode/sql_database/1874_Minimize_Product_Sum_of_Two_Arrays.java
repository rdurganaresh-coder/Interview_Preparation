package com.leetcode.sql_database;

class Solution1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += nums1[i] * nums2[n - i - 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1874 _tcSol = new Solution1874();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [5,3,4,2], nums2 = [4,2,2,5]");
        try {
            int[] nums1 = new int[]{5, 3, 4, 2};
            int[] nums2 = new int[]{4, 2, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minProductSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,1,4,5,7], nums2 = [3,2,4,8,6]");
        try {
            int[] nums1 = new int[]{2, 1, 4, 5, 7};
            int[] nums2 = new int[]{3, 2, 4, 8, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minProductSum(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "65");
        System.out.println();
    }
}
