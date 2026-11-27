package com.leetcode.sliding_window_two_pointers;

class Solution2447 {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int g = 0;
            for (int j = i; j < n; ++j) {
                g = gcd(g, nums[j]);
                if (g == k) {
                    ++ans;
                }
            }
        }
        return ans;
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
        Solution2447 _tcSol = new Solution2447();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [9,3,1,2,6,3], k = 3");
        try {
            int[] nums = new int[]{9, 3, 1, 2, 6, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayGCD(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4], k = 7");
        try {
            int[] nums = new int[]{4};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayGCD(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}