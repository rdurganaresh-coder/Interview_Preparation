package com.leetcode.arrays_hashing_greedy;

class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
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
        Solution1035 _tcSol = new Solution1035();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,4,2], nums2 = [1,2,4]");
        try {
            int[] nums1 = new int[]{1, 4, 2};
            int[] nums2 = new int[]{1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUncrossedLines(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]");
        try {
            int[] nums1 = new int[]{2, 5, 1, 2, 5};
            int[] nums2 = new int[]{10, 5, 2, 1, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUncrossedLines(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]");
        try {
            int[] nums1 = new int[]{1, 3, 7, 1, 7, 5};
            int[] nums2 = new int[]{1, 9, 2, 5, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUncrossedLines(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
