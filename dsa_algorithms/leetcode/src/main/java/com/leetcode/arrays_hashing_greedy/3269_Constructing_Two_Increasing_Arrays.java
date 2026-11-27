package com.leetcode.arrays_hashing_greedy;

class Solution3269 {
    public int minLargest(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            f[i][0] = nxt(f[i - 1][0], nums1[i - 1]);
        }
        for (int j = 1; j <= n; ++j) {
            f[0][j] = nxt(f[0][j - 1], nums2[j - 1]);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int x = nxt(f[i - 1][j], nums1[i - 1]);
                int y = nxt(f[i][j - 1], nums2[j - 1]);
                f[i][j] = Math.min(x, y);
            }
        }
        return f[m][n];
    }

    private int nxt(int x, int y) {
        return (x & 1 ^ y) == 1 ? x + 1 : x + 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3269 _tcSol = new Solution3269();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [], nums2 = [1,0,1,1]");
        try {
            int[] nums1 = new int[]{};
            int[] nums2 = new int[]{1, 0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minLargest(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [0,1,0,1], nums2 = [1,0,0,1]");
        try {
            int[] nums1 = new int[]{0, 1, 0, 1};
            int[] nums2 = new int[]{1, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minLargest(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [0,1,0,0,1], nums2 = [0,0,0,1]");
        try {
            int[] nums1 = new int[]{0, 1, 0, 0, 1};
            int[] nums2 = new int[]{0, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minLargest(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}
