package com.leetcode.arrays_hashing_greedy;

class Solution0870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] t = new int[n][2];
        for (int i = 0; i < n; ++i) {
            t[i] = new int[] {nums2[i], i};
        }
        Arrays.sort(t, (a, b) -> a[0] - b[0]);
        Arrays.sort(nums1);
        int[] ans = new int[n];
        int i = 0, j = n - 1;
        for (int v : nums1) {
            if (v <= t[i][0]) {
                ans[t[j--][1]] = v;
            } else {
                ans[t[i++][1]] = v;
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
        Solution0870 _tcSol = new Solution0870();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,7,11,15], nums2 = [1,10,4,11]");
        try {
            int[] nums1 = new int[]{2, 7, 11, 15};
            int[] nums2 = new int[]{1, 10, 4, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.advantageCount(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,11,7,15]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [12,24,8,32], nums2 = [13,25,32,11]");
        try {
            int[] nums1 = new int[]{12, 24, 8, 32};
            int[] nums2 = new int[]{13, 25, 32, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.advantageCount(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[24,32,8,12]");
        System.out.println();
    }
}