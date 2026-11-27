package com.leetcode.arrays_hashing_greedy;

class Solution1885 {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        long ans = 0;
        while (l < r) {
            while (l < r && nums[l] + nums[r] <= 0) {
                ++l;
            }
            ans += r - l;
            --r;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1885 _tcSol = new Solution1885();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,1,2,1], nums2 = [1,2,1,2]");
        try {
            int[] nums1 = new int[]{2, 1, 2, 1};
            int[] nums2 = new int[]{1, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,10,6,2], nums2 = [1,4,1,5]");
        try {
            int[] nums1 = new int[]{1, 10, 6, 2};
            int[] nums2 = new int[]{1, 4, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
