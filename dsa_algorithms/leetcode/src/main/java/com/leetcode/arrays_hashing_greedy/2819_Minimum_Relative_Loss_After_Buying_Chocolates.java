package com.leetcode.arrays_hashing_greedy;

class Solution2819 {
    private int n;
    private int[] prices;

    public long[] minimumRelativeLosses(int[] prices, int[][] queries) {
        n = prices.length;
        Arrays.sort(prices);
        this.prices = prices;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + prices[i];
        }
        int q = queries.length;
        long[] ans = new long[q];
        for (int i = 0; i < q; ++i) {
            int k = queries[i][0], m = queries[i][1];
            int l = f(k, m);
            int r = m - l;
            ans[i] = s[l] + 2L * k * r - (s[n] - s[n - r]);
        }
        return ans;
    }

    private int f(int k, int m) {
        int l = 0, r = Arrays.binarySearch(prices, k);
        if (r < 0) {
            r = -(r + 1);
        }
        r = Math.min(m, r);
        while (l < r) {
            int mid = (l + r) >> 1;
            int right = m - mid;
            if (prices[mid] < 2L * k - prices[n - right]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2819 _tcSol = new Solution2819();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [1,9,22,10,19], queries = [[18,4],[5,2]]");
        try {
            int[] prices = new int[]{1, 9, 22, 10, 19};
            int[][] queries = new int[][]{new int[]{18, 4}, new int[]{5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRelativeLosses(prices, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[34,-21]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,5,4,3,7,11,9], queries = [[5,4],[5,7],[7,3],[4,5]]");
        try {
            int[] prices = new int[]{1, 5, 4, 3, 7, 11, 9};
            int[][] queries = new int[][]{new int[]{5, 4}, new int[]{5, 7}, new int[]{7, 3}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRelativeLosses(prices, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,16,7,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [5,6,7], queries = [[10,1],[5,3],[3,3]]");
        try {
            int[] prices = new int[]{5, 6, 7};
            int[][] queries = new int[][]{new int[]{10, 1}, new int[]{5, 3}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRelativeLosses(prices, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,12,0]");
        System.out.println();
    }
}