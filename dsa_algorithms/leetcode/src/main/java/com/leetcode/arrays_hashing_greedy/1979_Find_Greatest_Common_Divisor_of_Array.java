package com.leetcode.arrays_hashing_greedy;

class Solution1979 {
    public int findGCD(int[] nums) {
        int a = 1, b = 1000;
        for (int x : nums) {
            a = Math.max(a, x);
            b = Math.min(b, x);
        }
        return gcd(a, b);
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
        Solution1979 _tcSol = new Solution1979();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,6,9,10]");
        try {
            int[] nums = new int[]{2, 5, 6, 9, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.findGCD(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,5,6,8,3]");
        try {
            int[] nums = new int[]{7, 5, 6, 8, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findGCD(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,3]");
        try {
            int[] nums = new int[]{3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findGCD(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}