package com.leetcode.arrays_hashing_greedy;

class Solution1049_2 {
    public int lastStoneWeightII(int[] stones) {
        int s = 0;
        for (int v : stones) {
            s += v;
        }
        int m = stones.length;
        int n = s >> 1;
        int[] dp = new int[n + 1];
        for (int v : stones) {
            for (int j = n; j >= v; --j) {
                dp[j] = Math.max(dp[j], dp[j - v] + v);
            }
        }
        return s - dp[n] * 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1049_2 _tcSol = new Solution1049_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [2,7,4,1,8,1]");
        try {
            int[] stones = new int[]{2, 7, 4, 1, 8, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastStoneWeightII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [31,26,33,21,40]");
        try {
            int[] stones = new int[]{31, 26, 33, 21, 40};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastStoneWeightII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}