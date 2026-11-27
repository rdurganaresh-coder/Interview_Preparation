package com.leetcode.arrays_hashing_greedy;

class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        int g = 0;
        for (int x : nums) {
            g = gcd(x, g);
        }
        return g == 1;
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
        Solution1250 _tcSol = new Solution1250();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [12,5,7,23]");
        try {
            int[] nums = new int[]{12, 5, 7, 23};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGoodArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [29,6,10]");
        try {
            int[] nums = new int[]{29, 6, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGoodArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,6]");
        try {
            int[] nums = new int[]{3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGoodArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}