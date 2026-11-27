package com.leetcode.dynamic_programming;

class Solution3466 {
    private int n;
    private int[] lane1;
    private int[] lane2;
    private Long[][][] f;

    public long maxCoins(int[] lane1, int[] lane2) {
        n = lane1.length;
        this.lane1 = lane1;
        this.lane2 = lane2;
        f = new Long[n][2][3];
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dfs(i, 0, 2));
        }
        return ans;
    }

    private long dfs(int i, int j, int k) {
        if (i >= n) {
            return 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int x = j == 0 ? lane1[i] : lane2[i];
        long ans = Math.max(x, dfs(i + 1, j, k) + x);
        if (k > 0) {
            ans = Math.max(ans, dfs(i + 1, j ^ 1, k - 1) + x);
            ans = Math.max(ans, dfs(i, j ^ 1, k - 1));
        }
        return f[i][j][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3466 _tcSol = new Solution3466();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "lane1 = [1,-2,-10,3], lane2 = [-5,10,0,1]");
        try {
            int[] lane1 = new int[]{1, -2, -10, 3};
            int[] lane2 = new int[]{-5, 10, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(lane1, lane2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "lane1 = [1,-1,-1,-1], lane2 = [0,3,4,-5]");
        try {
            int[] lane1 = new int[]{1, -1, -1, -1};
            int[] lane2 = new int[]{0, 3, 4, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(lane1, lane2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "lane1 = [-5,-4,-3], lane2 = [-1,2,3]");
        try {
            int[] lane1 = new int[]{-5, -4, -3};
            int[] lane2 = new int[]{-1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(lane1, lane2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "lane1 = [-3,-3,-3], lane2 = [9,-2,4]");
        try {
            int[] lane1 = new int[]{-3, -3, -3};
            int[] lane2 = new int[]{9, -2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(lane1, lane2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 5");
        System.out.println("  Input   : " + "lane1 = [-10], lane2 = [-2]");
        try {
            int[] lane1 = new int[]{-10};
            int[] lane2 = new int[]{-2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCoins(lane1, lane2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-2");
        System.out.println();
    }
}
