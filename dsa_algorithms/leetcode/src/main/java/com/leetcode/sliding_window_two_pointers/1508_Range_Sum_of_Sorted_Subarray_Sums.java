package com.leetcode.sliding_window_two_pointers;

class Solution1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        for (int i = 0, k = 0; i < n; ++i) {
            int s = 0;
            for (int j = i; j < n; ++j) {
                s += nums[j];
                arr[k++] = s;
            }
        }
        Arrays.sort(arr);
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int i = left - 1; i < right; ++i) {
            ans = (ans + arr[i]) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1508 _tcSol = new Solution1508();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4], n = 4, left = 1, right = 5");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int n = 4;
            int left = 1;
            int right = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeSum(nums, n, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4], n = 4, left = 3, right = 4");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int n = 4;
            int left = 3;
            int right = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeSum(nums, n, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4], n = 4, left = 1, right = 10");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int n = 4;
            int left = 1;
            int right = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.rangeSum(nums, n, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "50");
        System.out.println();
    }
}