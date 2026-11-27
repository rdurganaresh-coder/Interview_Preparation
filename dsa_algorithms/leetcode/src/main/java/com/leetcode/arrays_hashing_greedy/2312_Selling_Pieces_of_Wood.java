package com.leetcode.arrays_hashing_greedy;

class Solution2312 {
    private int[][] d;
    private Long[][] f;

    public long sellingWood(int m, int n, int[][] prices) {
        d = new int[m + 1][n + 1];
        f = new Long[m + 1][n + 1];
        for (var p : prices) {
            d[p[0]][p[1]] = p[2];
        }
        return dfs(m, n);
    }

    private long dfs(int h, int w) {
        if (f[h][w] != null) {
            return f[h][w];
        }
        long ans = d[h][w];
        for (int i = 1; i < h / 2 + 1; ++i) {
            ans = Math.max(ans, dfs(i, w) + dfs(h - i, w));
        }
        for (int i = 1; i < w / 2 + 1; ++i) {
            ans = Math.max(ans, dfs(h, i) + dfs(h, w - i));
        }
        return f[h][w] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2312 _tcSol = new Solution2312();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 5, prices = [[1,4,2],[2,2,7],[2,1,3]]");
        try {
            int m = 3;
            int n = 5;
            int[][] prices = new int[][]{new int[]{1, 4, 2}, new int[]{2, 2, 7}, new int[]{2, 1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sellingWood(m, n, prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 4, n = 6, prices = [[3,2,10],[1,4,2],[4,1,3]]");
        try {
            int m = 4;
            int n = 6;
            int[][] prices = new int[][]{new int[]{3, 2, 10}, new int[]{1, 4, 2}, new int[]{4, 1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sellingWood(m, n, prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();
    }
}