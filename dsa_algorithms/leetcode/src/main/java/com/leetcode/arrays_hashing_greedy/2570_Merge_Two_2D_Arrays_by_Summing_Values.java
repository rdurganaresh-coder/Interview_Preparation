package com.leetcode.arrays_hashing_greedy;

class Solution2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] cnt = new int[1001];
        for (var x : nums1) {
            cnt[x[0]] += x[1];
        }
        for (var x : nums2) {
            cnt[x[0]] += x[1];
        }
        int n = 0;
        for (int i = 0; i < 1001; ++i) {
            if (cnt[i] > 0) {
                ++n;
            }
        }
        int[][] ans = new int[n][2];
        for (int i = 0, j = 0; i < 1001; ++i) {
            if (cnt[i] > 0) {
                ans[j++] = new int[] {i, cnt[i]};
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
        Solution2570 _tcSol = new Solution2570();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]");
        try {
            int[][] nums1 = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{4, 5}};
            int[][] nums2 = new int[][]{new int[]{1, 4}, new int[]{3, 2}, new int[]{4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeArrays(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,6],[2,3],[3,2],[4,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]");
        try {
            int[][] nums1 = new int[][]{new int[]{2, 4}, new int[]{3, 6}, new int[]{5, 5}};
            int[][] nums2 = new int[][]{new int[]{1, 3}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeArrays(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3],[2,4],[3,6],[4,3],[5,5]]");
        System.out.println();
    }
}