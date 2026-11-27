package com.leetcode.matrices_grids;

class Solution0223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);
        int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1, by1);
        return a + b - Math.max(height, 0) * Math.max(width, 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0223 _tcSol = new Solution0223();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2");
        try {
            int ax1 = -3;
            int ay1 = 0;
            int ax2 = 3;
            int ay2 = 4;
            int bx1 = 0;
            int by1 = -1;
            int bx2 = 9;
            int by2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "45");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2");
        try {
            int ax1 = -2;
            int ay1 = -2;
            int ax2 = 2;
            int ay2 = 2;
            int bx1 = -2;
            int by1 = -2;
            int bx2 = 2;
            int by2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}