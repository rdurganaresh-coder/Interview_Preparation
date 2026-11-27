package com.leetcode.arrays_hashing_greedy;

class Solution1509 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(nums);
        long ans = 1L << 60;
        for (int l = 0; l <= 3; ++l) {
            int r = 3 - l;
            ans = Math.min(ans, (long) nums[n - 1 - r] - nums[l]);
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1509 _tcSol = new Solution1509();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,3,2,4]");
        try {
            int[] nums = new int[]{5, 3, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,0,10,14]");
        try {
            int[] nums = new int[]{1, 5, 0, 10, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,100,20]");
        try {
            int[] nums = new int[]{3, 100, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}