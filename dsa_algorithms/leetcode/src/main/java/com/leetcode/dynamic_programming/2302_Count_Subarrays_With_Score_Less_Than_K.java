package com.leetcode.dynamic_programming;

class Solution2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if ((s[i] - s[i - mid]) * mid < k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans += l;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2302 _tcSol = new Solution2302();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,4,3,5], k = 10");
        try {
            int[] nums = new int[]{2, 1, 4, 3, 5};
            long k = 10L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1], k = 5");
        try {
            int[] nums = new int[]{1, 1, 1};
            long k = 5L;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}