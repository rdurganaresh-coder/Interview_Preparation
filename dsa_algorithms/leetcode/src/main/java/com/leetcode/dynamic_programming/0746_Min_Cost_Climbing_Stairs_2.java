package com.leetcode.dynamic_programming;

class Solution0746_2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Math.min(f[i - 2] + cost[i - 2], f[i - 1] + cost[i - 1]);
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0746_2 _tcSol = new Solution0746_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [10,15,20]");
        try {
            int[] cost = new int[]{10, 15, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostClimbingStairs(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [1,100,1,1,1,100,1,1,100,1]");
        try {
            int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostClimbingStairs(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
