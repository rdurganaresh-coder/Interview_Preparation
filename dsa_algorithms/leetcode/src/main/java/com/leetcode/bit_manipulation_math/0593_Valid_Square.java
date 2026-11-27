package com.leetcode.bit_manipulation_math;

class Solution0593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3) && check(p1, p3, p4) && check(p1, p2, p4) && check(p2, p3, p4);
    }

    private boolean check(int[] a, int[] b, int[] c) {
        int x1 = a[0], y1 = a[1];
        int x2 = b[0], y2 = b[1];
        int x3 = c[0], y3 = c[1];
        int d1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int d2 = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
        int d3 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
        if (d1 == d2 && d1 + d2 == d3 && d1 > 0) {
            return true;
        }
        if (d1 == d3 && d1 + d3 == d2 && d1 > 0) {
            return true;
        }
        if (d2 == d3 && d2 + d3 == d1 && d2 > 0) {
            return true;
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0593 _tcSol = new Solution0593();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]");
        try {
            int[] p1 = new int[]{0, 0};
            int[] p2 = new int[]{1, 1};
            int[] p3 = new int[]{1, 0};
            int[] p4 = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSquare(p1, p2, p3, p4)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]");
        try {
            int[] p1 = new int[]{0, 0};
            int[] p2 = new int[]{1, 1};
            int[] p3 = new int[]{1, 0};
            int[] p4 = new int[]{0, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSquare(p1, p2, p3, p4)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]");
        try {
            int[] p1 = new int[]{1, 0};
            int[] p2 = new int[]{-1, 0};
            int[] p3 = new int[]{0, 1};
            int[] p4 = new int[]{0, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSquare(p1, p2, p3, p4)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}