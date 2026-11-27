package com.leetcode.matrices_grids;

class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0, mx = 0;
        for (var e : rectangles) {
            int x = Math.min(e[0], e[1]);
            if (mx < x) {
                mx = x;
                ans = 1;
            } else if (mx == x) {
                ++ans;
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
        Solution1725 _tcSol = new Solution1725();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rectangles = [[5,8],[3,9],[5,12],[16,5]]");
        try {
            int[][] rectangles = new int[][]{new int[]{5, 8}, new int[]{3, 9}, new int[]{5, 12}, new int[]{16, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodRectangles(rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rectangles = [[2,3],[3,7],[4,3],[3,7]]");
        try {
            int[][] rectangles = new int[][]{new int[]{2, 3}, new int[]{3, 7}, new int[]{4, 3}, new int[]{3, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodRectangles(rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}