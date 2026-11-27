package com.leetcode.arrays_hashing_greedy;

class Solution1838 {
    private int[] nums;
    private long[] s;
    private int k;

    public int maxFrequency(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        Arrays.sort(nums);
        int n = nums.length;
        s = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int m) {
        for (int i = m; i <= nums.length; ++i) {
            if (1L * nums[i - 1] * m - (s[i] - s[i - m]) <= k) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1838 _tcSol = new Solution1838();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4], k = 5");
        try {
            int[] nums = new int[]{1, 2, 4};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,8,13], k = 5");
        try {
            int[] nums = new int[]{1, 4, 8, 13};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,9,6], k = 2");
        try {
            int[] nums = new int[]{3, 9, 6};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}