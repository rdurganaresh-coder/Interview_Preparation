package com.leetcode.dynamic_programming;

class Solution2098 {
    public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < k; ++i) {
            ans += nums[n - i - 1];
        }
        if (ans % 2 == 0) {
            return ans;
        }
        final int inf = 1 << 29;
        int mx1 = -inf, mx2 = -inf;
        for (int i = 0; i < n - k; ++i) {
            if (nums[i] % 2 == 1) {
                mx1 = nums[i];
            } else {
                mx2 = nums[i];
            }
        }
        int mi1 = inf, mi2 = inf;
        for (int i = n - 1; i >= n - k; --i) {
            if (nums[i] % 2 == 1) {
                mi2 = nums[i];
            } else {
                mi1 = nums[i];
            }
        }
        ans = Math.max(ans - mi1 + mx1, ans - mi2 + mx2);
        return ans < 0 ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2098 _tcSol = new Solution2098();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,1,5,3,1], k = 3");
        try {
            int[] nums = new int[]{4, 1, 5, 3, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestEvenSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,6,2], k = 3");
        try {
            int[] nums = new int[]{4, 6, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestEvenSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,5], k = 1");
        try {
            int[] nums = new int[]{1, 3, 5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestEvenSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}