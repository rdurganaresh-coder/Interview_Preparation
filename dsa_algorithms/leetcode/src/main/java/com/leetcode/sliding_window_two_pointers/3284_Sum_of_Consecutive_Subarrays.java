package com.leetcode.sliding_window_two_pointers;

class Solution3284 {
    public int getSum(int[] nums) {
        final int mod = (int) 1e9 + 7;
        long s = nums[0], t = nums[0], ans = nums[0];
        int f = 1, g = 1;
        for (int i = 1; i < nums.length; ++i) {
            int x = nums[i - 1], y = nums[i];
            if (y - x == 1) {
                ++f;
                s += 1L * f * y;
                ans = (ans + s) % mod;
            } else {
                f = 1;
                s = y;
            }
            if (y - x == -1) {
                ++g;
                t += 1L * g * y;
                ans = (ans + t) % mod;
            } else {
                g = 1;
                t = y;
            }
            if (Math.abs(y - x) != 1) {
                ans = (ans + y) % mod;
            }
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3284 _tcSol = new Solution3284();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,5,7]");
        try {
            int[] nums = new int[]{1, 3, 5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,6,1,2]");
        try {
            int[] nums = new int[]{7, 6, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();
    }
}
