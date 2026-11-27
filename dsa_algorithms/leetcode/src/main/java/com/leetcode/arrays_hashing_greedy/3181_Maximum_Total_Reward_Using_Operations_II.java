package com.leetcode.arrays_hashing_greedy;

import java.math.BigInteger;

class Solution3181 {
    public int maxTotalReward(int[] rewardValues) {
        int[] nums = Arrays.stream(rewardValues).distinct().sorted().toArray();
        BigInteger f = BigInteger.ONE;
        for (int v : nums) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            BigInteger shifted = f.and(mask).shiftLeft(v);
            f = f.or(shifted);
        }
        return f.bitLength() - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3181 _tcSol = new Solution3181();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rewardValues = [1,1,3,3]");
        try {
            int[] rewardValues = new int[]{1, 1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalReward(rewardValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rewardValues = [1,6,4,3,2]");
        try {
            int[] rewardValues = new int[]{1, 6, 4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalReward(rewardValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}
