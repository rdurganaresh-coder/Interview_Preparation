package com.leetcode.dynamic_programming;

class Solution2560 {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (f(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] nums, int x) {
        int cnt = 0, j = -2;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > x || i == j + 1) {
                continue;
            }
            ++cnt;
            j = i;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2560 _tcSol = new Solution2560();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,5,9], k = 2");
        try {
            int[] nums = new int[]{2, 3, 5, 9};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCapability(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,7,9,3,1], k = 2");
        try {
            int[] nums = new int[]{2, 7, 9, 3, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCapability(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}