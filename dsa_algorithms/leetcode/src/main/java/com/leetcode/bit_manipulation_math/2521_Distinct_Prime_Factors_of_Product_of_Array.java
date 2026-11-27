package com.leetcode.bit_manipulation_math;

class Solution2521 {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) {
            for (int i = 2; i <= n / i; ++i) {
                if (n % i == 0) {
                    s.add(i);
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
            if (n > 1) {
                s.add(n);
            }
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2521 _tcSol = new Solution2521();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,3,7,10,6]");
        try {
            int[] nums = new int[]{2, 4, 3, 7, 10, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctPrimeFactors(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,8,16]");
        try {
            int[] nums = new int[]{2, 4, 8, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctPrimeFactors(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}