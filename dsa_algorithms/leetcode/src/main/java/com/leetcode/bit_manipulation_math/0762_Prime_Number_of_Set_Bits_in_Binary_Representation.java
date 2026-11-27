package com.leetcode.bit_manipulation_math;

class Solution0762 {
    private static Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            if (primes.contains(Integer.bitCount(i))) {
                ++ans;
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
        Solution0762 _tcSol = new Solution0762();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "left = 6, right = 10");
        try {
            int left = 6;
            int right = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrimeSetBits(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "left = 10, right = 15");
        try {
            int left = 10;
            int right = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPrimeSetBits(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}