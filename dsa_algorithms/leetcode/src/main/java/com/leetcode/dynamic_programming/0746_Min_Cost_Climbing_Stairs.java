package com.leetcode.dynamic_programming;

class Solution0746 {
    private Integer[] f;
    private int[] cost;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        f = new Integer[cost.length];
        return Math.min(dfs(0), dfs(1));
    }

    private int dfs(int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (f[i] == null) {
            f[i] = cost[i] + Math.min(dfs(i + 1), dfs(i + 2));
        }
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0746 _tcSol = new Solution0746();
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
