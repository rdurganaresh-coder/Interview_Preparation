package com.leetcode.arrays_hashing_greedy;

class Solution3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        for (int x : nums1) {
            if (x % k == 0) {
                cnt1.merge(x / k, 1, Integer::sum);
            }
        }
        if (cnt1.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int x : nums2) {
            cnt2.merge(x, 1, Integer::sum);
        }
        long ans = 0;
        int mx = Collections.max(cnt1.keySet());
        for (var e : cnt2.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int s = 0;
            for (int y = x; y <= mx; y += x) {
                s += cnt1.getOrDefault(y, 0);
            }
            ans += 1L * s * v;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3164 _tcSol = new Solution3164();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,3,4], nums2 = [1,3,4], k = 1");
        try {
            int[] nums1 = new int[]{1, 3, 4};
            int[] nums2 = new int[]{1, 3, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2,4,12], nums2 = [2,4], k = 3");
        try {
            int[] nums1 = new int[]{1, 2, 4, 12};
            int[] nums2 = new int[]{2, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}