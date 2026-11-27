package com.leetcode.matrices_grids;

class Solution0836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];
        return !(y3 >= y2 || y4 <= y1 || x3 >= x2 || x4 <= x1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0836 _tcSol = new Solution0836();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rec1 = [0,0,2,2], rec2 = [1,1,3,3]");
        try {
            int[] rec1 = new int[]{0, 0, 2, 2};
            int[] rec2 = new int[]{1, 1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.isRectangleOverlap(rec1, rec2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rec1 = [0,0,1,1], rec2 = [1,0,2,1]");
        try {
            int[] rec1 = new int[]{0, 0, 1, 1};
            int[] rec2 = new int[]{1, 0, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isRectangleOverlap(rec1, rec2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rec1 = [0,0,1,1], rec2 = [2,2,3,3]");
        try {
            int[] rec1 = new int[]{0, 0, 1, 1};
            int[] rec2 = new int[]{2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.isRectangleOverlap(rec1, rec2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}