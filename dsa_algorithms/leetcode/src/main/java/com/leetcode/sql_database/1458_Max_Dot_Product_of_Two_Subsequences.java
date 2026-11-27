package com.leetcode.sql_database;

class Solution1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        for (var g : f) {
            Arrays.fill(g, Integer.MIN_VALUE);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int v = nums1[i - 1] * nums2[j - 1];
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                f[i][j] = Math.max(f[i][j], Math.max(f[i - 1][j - 1], 0) + v);
            }
        }
        return f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1458 _tcSol = new Solution1458();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,1,-2,5], nums2 = [3,0,-6]");
        try {
            int[] nums1 = new int[]{2, 1, -2, 5};
            int[] nums2 = new int[]{3, 0, -6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDotProduct(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,-2], nums2 = [2,-6,7]");
        try {
            int[] nums1 = new int[]{3, -2};
            int[] nums2 = new int[]{2, -6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDotProduct(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [-1,-1], nums2 = [1,1]");
        try {
            int[] nums1 = new int[]{-1, -1};
            int[] nums2 = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDotProduct(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
