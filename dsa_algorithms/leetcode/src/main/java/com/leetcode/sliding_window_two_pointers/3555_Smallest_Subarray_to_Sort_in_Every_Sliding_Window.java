package com.leetcode.sliding_window_two_pointers;

class Solution3555 {
    private int[] nums;
    private final int inf = 1 << 30;

    public int[] minSubarraySort(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; ++i) {
            ans[i] = f(i, i + k - 1);
        }
        return ans;
    }

    private int f(int i, int j) {
        int mi = inf, mx = -inf;
        int l = -1, r = -1;
        for (int k = i; k <= j; ++k) {
            if (nums[k] < mx) {
                r = k;
            } else {
                mx = nums[k];
            }
            int p = j - k + i;
            if (nums[p] > mi) {
                l = p;
            } else {
                mi = nums[p];
            }
        }
        return r == -1 ? 0 : r - l + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3555 _tcSol = new Solution3555();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2,4,5], k = 3");
        try {
            int[] nums = new int[]{1, 3, 2, 4, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubarraySort(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,4,3,2,1], k = 4");
        try {
            int[] nums = new int[]{5, 4, 3, 2, 1};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubarraySort(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,4]");
        System.out.println();
    }
}