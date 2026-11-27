package com.leetcode.dynamic_programming;

class Solution2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int x0 = startPos[0], y0 = startPos[1];
        int x1 = homePos[0], y1 = homePos[1];
        int dx = x0 < x1 ? calc(rowCosts, x0 + 1, x1) : calc(rowCosts, x1, x0 - 1);
        int dy = y0 < y1 ? calc(colCosts, y0 + 1, y1) : calc(colCosts, y1, y0 - 1);
        return dx + dy;
    }

    private int calc(int[] nums, int i, int j) {
        int res = 0;
        for (int k = i; k <= j; ++k) {
            res += nums[k];
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2087 _tcSol = new Solution2087();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startPos = [1, 0], homePos = [2, 3], rowCosts = [5, 4, 3], colCosts = [8, 2, 6, 7]");
        try {
            int[] startPos = new int[]{1, 0};
            int[] homePos = new int[]{2, 3};
            int[] rowCosts = new int[]{5, 4, 3};
            int[] colCosts = new int[]{8, 2, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(startPos, homePos, rowCosts, colCosts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startPos = [0, 0], homePos = [0, 0], rowCosts = [5], colCosts = [26]");
        try {
            int[] startPos = new int[]{0, 0};
            int[] homePos = new int[]{0, 0};
            int[] rowCosts = new int[]{5};
            int[] colCosts = new int[]{26};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(startPos, homePos, rowCosts, colCosts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
