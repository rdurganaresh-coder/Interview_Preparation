package com.leetcode.sliding_window_two_pointers;

class Solution2470 {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int a = 1;
            for (int j = i; j < nums.length; ++j) {
                if (k % nums[j] != 0) {
                    break;
                }
                a = lcm(a, nums[j]);
                if (a == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
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
        Solution2470 _tcSol = new Solution2470();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,6,2,7,1], k = 6");
        try {
            int[] nums = new int[]{3, 6, 2, 7, 1};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayLCM(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3], k = 2");
        try {
            int[] nums = new int[]{3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayLCM(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
