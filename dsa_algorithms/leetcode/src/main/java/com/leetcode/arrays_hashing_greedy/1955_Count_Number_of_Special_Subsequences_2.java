package com.leetcode.arrays_hashing_greedy;

class Solution1955_2 {
    public int countSpecialSubsequences(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int n = nums.length;
        int[] f = new int[3];
        f[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == 0) {
                f[0] = (2 * f[0] % mod + 1) % mod;
            } else if (nums[i] == 1) {
                f[1] = (f[0] + 2 * f[1] % mod) % mod;
            } else {
                f[2] = (f[1] + 2 * f[2] % mod) % mod;
            }
        }
        return f[2];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1955_2 _tcSol = new Solution1955_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2,2]");
        try {
            int[] nums = new int[]{0, 1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSpecialSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,0,0]");
        try {
            int[] nums = new int[]{2, 2, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSpecialSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,1,2,0,1,2]");
        try {
            int[] nums = new int[]{0, 1, 2, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSpecialSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}