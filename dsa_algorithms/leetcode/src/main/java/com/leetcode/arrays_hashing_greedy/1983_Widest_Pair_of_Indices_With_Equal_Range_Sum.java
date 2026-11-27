package com.leetcode.arrays_hashing_greedy;

class Solution1983 {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, -1);
        int n = nums1.length;
        int s = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            s += nums1[i] - nums2[i];
            if (d.containsKey(s)) {
                ans = Math.max(ans, i - d.get(s));
            } else {
                d.put(s, i);
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
        Solution1983 _tcSol = new Solution1983();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,1,0,1], nums2 = [0,1,1,0]");
        try {
            int[] nums1 = new int[]{1, 1, 0, 1};
            int[] nums2 = new int[]{0, 1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.widestPairOfIndices(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [0,1], nums2 = [1,1]");
        try {
            int[] nums1 = new int[]{0, 1};
            int[] nums2 = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.widestPairOfIndices(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [0], nums2 = [1]");
        try {
            int[] nums1 = new int[]{0};
            int[] nums2 = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.widestPairOfIndices(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}