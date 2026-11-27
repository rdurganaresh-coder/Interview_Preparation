package com.leetcode.bit_manipulation_math;

import java.util.*;

class Solution3591 {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }

        for (int x : cnt.values()) {
            if (isPrime(x)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3591 _tcSol = new Solution3591();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPrimeFrequency(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPrimeFrequency(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,2,2,4,4]");
        try {
            int[] nums = new int[]{2, 2, 2, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPrimeFrequency(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
