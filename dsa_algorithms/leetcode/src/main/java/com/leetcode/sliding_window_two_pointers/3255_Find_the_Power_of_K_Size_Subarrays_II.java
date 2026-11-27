package com.leetcode.sliding_window_two_pointers;

class Solution3255 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                f[i] = f[i - 1] + 1;
            }
        }
        int[] ans = new int[n - k + 1];
        for (int i = k - 1; i < n; ++i) {
            ans[i - k + 1] = f[i] >= k ? nums[i] : -1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3255 _tcSol = new Solution3255();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,3,2,5], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 3, 2, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultsArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4,-1,-1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,2], k = 4");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultsArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2,3,2,3,2], k = 2");
        try {
            int[] nums = new int[]{3, 2, 3, 2, 3, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultsArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,3,-1,3,-1]");
        System.out.println();
    }
}
