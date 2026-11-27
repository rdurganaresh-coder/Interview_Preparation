package com.leetcode.arrays_hashing_greedy;

class Solution3432 {
    public int countPartitions(int[] nums) {
        int l = 0, r = 0;
        for (int x : nums) {
            r += x;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            l += nums[i];
            r -= nums[i];
            if ((l - r) % 2 == 0) {
                ++ans;
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
        Solution3432 _tcSol = new Solution3432();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,10,3,7,6]");
        try {
            int[] nums = new int[]{10, 10, 3, 7, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPartitions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPartitions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,4,6,8]");
        try {
            int[] nums = new int[]{2, 4, 6, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPartitions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
