package com.leetcode.sliding_window_two_pointers;

class Solution2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] cnt = new int[101];
        for (int i = 0; i < k; ++i) {
            ++cnt[nums[i] + 50];
        }
        int[] ans = new int[n - k + 1];
        ans[0] = f(cnt, x);
        for (int i = k, j = 1; i < n; ++i) {
            ++cnt[nums[i] + 50];
            --cnt[nums[i - k] + 50];
            ans[j++] = f(cnt, x);
        }
        return ans;
    }

    private int f(int[] cnt, int x) {
        int s = 0;
        for (int i = 0; i < 50; ++i) {
            s += cnt[i];
            if (s >= x) {
                return i - 50;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2653 _tcSol = new Solution2653();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-1,-3,-2,3], k = 3, x = 2");
        try {
            int[] nums = new int[]{1, -1, -3, -2, 3};
            int k = 3;
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSubarrayBeauty(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-2,-2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,-4,-5], k = 2, x = 2");
        try {
            int[] nums = new int[]{-1, -2, -3, -4, -5};
            int k = 2;
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSubarrayBeauty(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-2,-3,-4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-3,1,2,-3,0,-3], k = 2, x = 1");
        try {
            int[] nums = new int[]{-3, 1, 2, -3, 0, -3};
            int k = 2;
            int x = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSubarrayBeauty(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-3,0,-3,-3,-3]");
        System.out.println();
    }
}