package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree2921 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2921(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mx = 0;
        while (x > 0) {
            mx = Math.max(mx, c[x]);
            x -= x & -x;
        }
        return mx;
    }
}

class Solution2921 {
    public int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int m = 0;
        for (int x : prices) {
            m = Math.max(m, x);
        }
        BinaryIndexedTree2921 tree1 = new BinaryIndexedTree2921(m + 1);
        BinaryIndexedTree2921 tree2 = new BinaryIndexedTree2921(m + 1);
        for (int i = 0; i < n; ++i) {
            int x = prices[i];
            left[i] = tree1.query(x - 1);
            tree1.update(x, profits[i]);
        }
        for (int i = n - 1; i >= 0; --i) {
            int x = m + 1 - prices[i];
            right[i] = tree2.query(x - 1);
            tree2.update(x, profits[i]);
        }
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + profits[i] + right[i]);
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
        Solution2921 _tcSol = new Solution2921();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [10,2,3,4], profits = [100,2,7,10]");
        try {
            int[] prices = new int[]{10, 2, 3, 4};
            int[] profits = new int[]{100, 2, 7, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, profits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,2,3,4,5], profits = [1,5,3,4,6]");
        try {
            int[] prices = new int[]{1, 2, 3, 4, 5};
            int[] profits = new int[]{1, 5, 3, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, profits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [4,3,2,1], profits = [33,20,19,87]");
        try {
            int[] prices = new int[]{4, 3, 2, 1};
            int[] profits = new int[]{33, 20, 19, 87};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(prices, profits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}