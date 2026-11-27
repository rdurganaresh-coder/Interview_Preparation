package com.leetcode.sql_database;

class Solution2438 {
    public int[] productQueries(int n, int[][] queries) {
        int[] powers = new int[Integer.bitCount(n)];
        for (int i = 0; n > 0; ++i) {
            int x = n & -n;
            powers[i] = x;
            n -= x;
        }
        int m = queries.length;
        int[] ans = new int[m];
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            long x = 1;
            for (int j = l; j <= r; ++j) {
                x = x * powers[j] % mod;
            }
            ans[i] = (int) x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2438 _tcSol = new Solution2438();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 15, queries = [[0,1],[2,2],[0,3]]");
        try {
            int n = 15;
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{2, 2}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.productQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,64]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, queries = [[0,0]]");
        try {
            int n = 2;
            int[][] queries = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.productQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2]");
        System.out.println();
    }
}
