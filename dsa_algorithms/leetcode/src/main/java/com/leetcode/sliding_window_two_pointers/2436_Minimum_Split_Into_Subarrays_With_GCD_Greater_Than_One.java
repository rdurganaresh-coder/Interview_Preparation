package com.leetcode.sliding_window_two_pointers;

class Solution2436 {
    public int minimumSplits(int[] nums) {
        int ans = 1, g = 0;
        for (int x : nums) {
            g = gcd(g, x);
            if (g == 1) {
                ++ans;
                g = x;
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
        Solution2436 _tcSol = new Solution2436();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [12,6,3,14,8]");
        try {
            int[] nums = new int[]{12, 6, 3, 14, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSplits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,12,6,14]");
        try {
            int[] nums = new int[]{4, 12, 6, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSplits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}