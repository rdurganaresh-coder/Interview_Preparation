package com.leetcode.bit_manipulation_math;

class Solution3115 {
    public int maximumPrimeDifference(int[] nums) {
        for (int i = 0;; ++i) {
            if (isPrime(nums[i])) {
                for (int j = nums.length - 1;; --j) {
                    if (isPrime(nums[j])) {
                        return j - i;
                    }
                }
            }
        }
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int v = 2; v * v <= x; ++v) {
            if (x % v == 0) {
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
        Solution3115 _tcSol = new Solution3115();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,9,5,3]");
        try {
            int[] nums = new int[]{4, 2, 9, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPrimeDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,8,2,8]");
        try {
            int[] nums = new int[]{4, 8, 2, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPrimeDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}