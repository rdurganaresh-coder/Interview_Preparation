package com.leetcode.sliding_window_two_pointers;

class Solution2464_2 {
    public int validSubarraySplit(int[] nums) {
        int n = nums.length;
        int inf = 0x3f3f3f3f;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i] = inf;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (gcd(nums[i], nums[j]) > 1) {
                    f[i] = Math.min(f[i], 1 + f[j + 1]);
                }
            }
        }
        return f[0] < inf ? f[0] : -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2464_2 _tcSol = new Solution2464_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,6,3,4,3]");
        try {
            int[] nums = new int[]{2, 6, 3, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubarraySplit(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,5]");
        try {
            int[] nums = new int[]{3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubarraySplit(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1]");
        try {
            int[] nums = new int[]{1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubarraySplit(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
