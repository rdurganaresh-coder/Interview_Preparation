package com.leetcode.arrays_hashing_greedy;

class Solution2280 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int dx = 0, dy = 1;
        int ans = 0;
        for (int i = 1; i < stockPrices.length; ++i) {
            int x = stockPrices[i - 1][0], y = stockPrices[i - 1][1];
            int x1 = stockPrices[i][0], y1 = stockPrices[i][1];
            int dx1 = x1 - x, dy1 = y1 - y;
            if ((long) dy * dx1 != (long) dx * dy1) {
                ++ans;
            }
            dx = dx1;
            dy = dy1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2280 _tcSol = new Solution2280();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]");
        try {
            int[][] stockPrices = new int[][]{new int[]{1, 7}, new int[]{2, 6}, new int[]{3, 5}, new int[]{4, 4}, new int[]{5, 4}, new int[]{6, 3}, new int[]{7, 2}, new int[]{8, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLines(stockPrices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stockPrices = [[3,4],[1,2],[7,8],[2,3]]");
        try {
            int[][] stockPrices = new int[][]{new int[]{3, 4}, new int[]{1, 2}, new int[]{7, 8}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLines(stockPrices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}