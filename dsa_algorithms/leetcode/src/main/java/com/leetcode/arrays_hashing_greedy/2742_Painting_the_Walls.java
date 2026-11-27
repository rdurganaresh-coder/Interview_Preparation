package com.leetcode.arrays_hashing_greedy;

class Solution2742 {
    private int n;
    private int[] cost;
    private int[] time;
    private Integer[][] f;

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        this.cost = cost;
        this.time = time;
        f = new Integer[n][n << 1 | 1];
        return dfs(0, n);
    }

    private int dfs(int i, int j) {
        if (n - i <= j - n) {
            return 0;
        }
        if (i >= n) {
            return 1 << 30;
        }
        if (f[i][j] == null) {
            f[i][j] = Math.min(dfs(i + 1, j + time[i]) + cost[i], dfs(i + 1, j - 1));
        }
        return f[i][j];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2742 _tcSol = new Solution2742();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [1,2,3,2], time = [1,2,3,2]");
        try {
            int[] cost = new int[]{1, 2, 3, 2};
            int[] time = new int[]{1, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.paintWalls(cost, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [2,3,4,2], time = [1,1,1,1]");
        try {
            int[] cost = new int[]{2, 3, 4, 2};
            int[] time = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.paintWalls(cost, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}