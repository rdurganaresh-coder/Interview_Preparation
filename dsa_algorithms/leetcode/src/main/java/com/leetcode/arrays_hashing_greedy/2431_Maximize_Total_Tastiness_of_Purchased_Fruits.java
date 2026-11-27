package com.leetcode.arrays_hashing_greedy;

class Solution2431 {
    private int[][][] f;
    private int[] price;
    private int[] tastiness;
    private int n;

    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        n = price.length;
        this.price = price;
        this.tastiness = tastiness;
        f = new int[n][maxAmount + 1][maxCoupons + 1];
        return dfs(0, maxAmount, maxCoupons);
    }

    private int dfs(int i, int j, int k) {
        if (i == n) {
            return 0;
        }
        if (f[i][j][k] != 0) {
            return f[i][j][k];
        }
        int ans = dfs(i + 1, j, k);
        if (j >= price[i]) {
            ans = Math.max(ans, dfs(i + 1, j - price[i], k) + tastiness[i]);
        }
        if (j >= price[i] / 2 && k > 0) {
            ans = Math.max(ans, dfs(i + 1, j - price[i] / 2, k - 1) + tastiness[i]);
        }
        f[i][j][k] = ans;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2431 _tcSol = new Solution2431();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "price = [10,20,20], tastiness = [5,8,8], maxAmount = 20, maxCoupons = 1");
        try {
            int[] price = new int[]{10, 20, 20};
            int[] tastiness = new int[]{5, 8, 8};
            int maxAmount = 20;
            int maxCoupons = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTastiness(price, tastiness, maxAmount, maxCoupons)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "price = [10,15,7], tastiness = [5,8,20], maxAmount = 10, maxCoupons = 2");
        try {
            int[] price = new int[]{10, 15, 7};
            int[] tastiness = new int[]{5, 8, 20};
            int maxAmount = 10;
            int maxCoupons = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTastiness(price, tastiness, maxAmount, maxCoupons)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();
    }
}