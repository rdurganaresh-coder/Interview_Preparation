package com.leetcode.arrays_hashing_greedy;

class Solution2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int k = k1 + k2;
        long s = 0;
        int mx = 0;
        int[] cnt = new int[100001];
        for (int i = 0; i < nums1.length; ++i) {
            int v = Math.abs(nums1[i] - nums2[i]);
            ++cnt[v];
            s += v;
            mx = Math.max(mx, v);
        }
        if (s <= k) {
            return 0;
        }
        for (int v = mx; v > 0 && k > 0; --v) {
            if (cnt[v] == 0) {
                continue;
            }
            int take = Math.min(cnt[v], k);
            k -= take;
            cnt[v] -= take;
            cnt[v - 1] += take;
        }
        long ans = 0;
        for (int v = 0; v <= mx; ++v) {
            ans += (long) v * v * cnt[v];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2333 _tcSol = new Solution2333();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0");
        try {
            int[] nums1 = new int[]{1, 2, 3, 4};
            int[] nums2 = new int[]{2, 10, 20, 19};
            int k1 = 0;
            int k2 = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSumSquareDiff(nums1, nums2, k1, k2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "579");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1");
        try {
            int[] nums1 = new int[]{1, 4, 10, 12};
            int[] nums2 = new int[]{5, 8, 6, 9};
            int k1 = 1;
            int k2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSumSquareDiff(nums1, nums2, k1, k2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "43");
        System.out.println();
    }
}
