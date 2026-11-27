package com.leetcode.matrices_grids;

class Solution1401 {
    public boolean checkOverlap(
        int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int a = f(x1, x2, xCenter);
        int b = f(y1, y2, yCenter);
        return a * a + b * b <= radius * radius;
    }

    private int f(int i, int j, int k) {
        if (i <= k && k <= j) {
            return 0;
        }
        return k < i ? i - k : k - j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1401 _tcSol = new Solution1401();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1");
        try {
            int radius = 1;
            int xCenter = 0;
            int yCenter = 0;
            int x1 = 1;
            int y1 = -1;
            int x2 = 3;
            int y2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1");
        try {
            int radius = 1;
            int xCenter = 1;
            int yCenter = 1;
            int x1 = 1;
            int y1 = -3;
            int x2 = 2;
            int y2 = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1");
        try {
            int radius = 1;
            int xCenter = 0;
            int yCenter = 0;
            int x1 = -1;
            int y1 = 0;
            int x2 = 0;
            int y2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}