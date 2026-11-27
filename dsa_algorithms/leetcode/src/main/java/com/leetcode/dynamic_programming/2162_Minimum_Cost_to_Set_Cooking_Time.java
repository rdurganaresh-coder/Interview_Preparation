package com.leetcode.dynamic_programming;

class Solution2162 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int m = targetSeconds / 60;
        int s = targetSeconds % 60;
        return Math.min(
            f(m, s, startAt, moveCost, pushCost), f(m - 1, s + 60, startAt, moveCost, pushCost));
    }

    private int f(int m, int s, int prev, int moveCost, int pushCost) {
        if (m < 0 || m > 99 || s < 0 || s > 99) {
            return Integer.MAX_VALUE;
        }
        int[] arr = new int[] {m / 10, m % 10, s / 10, s % 10};
        int i = 0;
        for (; i < 4 && arr[i] == 0; ++i)
            ;
        int t = 0;
        for (; i < 4; ++i) {
            if (arr[i] != prev) {
                t += moveCost;
            }
            t += pushCost;
            prev = arr[i];
        }
        return t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2162 _tcSol = new Solution2162();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startAt = 1, moveCost = 2, pushCost = 1, targetSeconds = 600");
        try {
            int startAt = 1;
            int moveCost = 2;
            int pushCost = 1;
            int targetSeconds = 600;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostSetTime(startAt, moveCost, pushCost, targetSeconds)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startAt = 0, moveCost = 1, pushCost = 2, targetSeconds = 76");
        try {
            int startAt = 0;
            int moveCost = 1;
            int pushCost = 2;
            int targetSeconds = 76;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostSetTime(startAt, moveCost, pushCost, targetSeconds)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}