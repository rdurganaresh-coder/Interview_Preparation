package com.leetcode.arrays_hashing_greedy;

class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2006 _tcSol = new Solution2006();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,1], k = 1");
        try {
            int[] nums = new int[]{1, 2, 2, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3], k = 3");
        try {
            int[] nums = new int[]{1, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2,1,5,4], k = 2");
        try {
            int[] nums = new int[]{3, 2, 1, 5, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}