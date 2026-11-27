package com.leetcode.dynamic_programming;

class Solution2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = divisors[0];
        int mx = 0;
        for (int div : divisors) {
            int cnt = 0;
            for (int x : nums) {
                if (x % div == 0) {
                    ++cnt;
                }
            }
            if (mx < cnt) {
                mx = cnt;
                ans = div;
            } else if (mx == cnt) {
                ans = Math.min(ans, div);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2644 _tcSol = new Solution2644();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,9,15,50], divisors = [5,3,7,2]");
        try {
            int[] nums = new int[]{2, 9, 15, 50};
            int[] divisors = new int[]{5, 3, 7, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDivScore(nums, divisors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,7,9,3,9], divisors = [5,2,3]");
        try {
            int[] nums = new int[]{4, 7, 9, 3, 9};
            int[] divisors = new int[]{5, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDivScore(nums, divisors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [20,14,21,10], divisors = [10,16,20]");
        try {
            int[] nums = new int[]{20, 14, 21, 10};
            int[] divisors = new int[]{10, 16, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDivScore(nums, divisors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}