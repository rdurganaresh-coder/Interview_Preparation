package com.leetcode.arrays_hashing_greedy;

class Solution0956 {
    private Integer[][] f;
    private int[] rods;
    private int n;

    public int tallestBillboard(int[] rods) {
        int s = 0;
        for (int x : rods) {
            s += x;
        }
        n = rods.length;
        this.rods = rods;
        f = new Integer[n][s + 1];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n) {
            return j == 0 ? 0 : -(1 << 30);
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = Math.max(dfs(i + 1, j), dfs(i + 1, j + rods[i]));
        ans = Math.max(ans, dfs(i + 1, Math.abs(rods[i] - j)) + Math.min(j, rods[i]));
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0956 _tcSol = new Solution0956();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rods = [1,2,3,6]");
        try {
            int[] rods = new int[]{1, 2, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.tallestBillboard(rods)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rods = [1,2,3,4,5,6]");
        try {
            int[] rods = new int[]{1, 2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.tallestBillboard(rods)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rods = [1,2]");
        try {
            int[] rods = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.tallestBillboard(rods)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}