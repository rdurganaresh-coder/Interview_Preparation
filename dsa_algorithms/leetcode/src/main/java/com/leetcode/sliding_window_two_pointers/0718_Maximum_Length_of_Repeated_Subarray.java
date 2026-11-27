package com.leetcode.sliding_window_two_pointers;

class Solution0718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0718 _tcSol = new Solution0718();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 2, 1};
            int[] nums2 = new int[]{3, 2, 1, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLength(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]");
        try {
            int[] nums1 = new int[]{0, 0, 0, 0, 0};
            int[] nums2 = new int[]{0, 0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLength(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}