package com.leetcode.arrays_hashing_greedy;

class Solution3453 {
    private int[][] squares;
    private double s;

    private boolean check(double y1) {
        double t = 0.0;
        for (int[] a : squares) {
            int y = a[1];
            int l = a[2];
            if (y < y1) {
                t += (double) l * Math.min(y1 - y, l);
            }
        }
        return t >= s / 2.0;
    }

    public double separateSquares(int[][] squares) {
        this.squares = squares;
        s = 0.0;
        double l = 0.0;
        double r = 0.0;
        for (int[] a : squares) {
            s += (double) a[2] * a[2];
            r = Math.max(r, a[1] + a[2]);
        }

        double eps = 1e-5;
        while (r - l > eps) {
            double mid = (l + r) / 2.0;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3453 _tcSol = new Solution3453();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "squares = [[0,0,1],[2,2,1]]");
        try {
            int[][] squares = new int[][]{new int[]{0, 0, 1}, new int[]{2, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.separateSquares(squares)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "squares = [[0,0,2],[1,1,1]]");
        try {
            int[][] squares = new int[][]{new int[]{0, 0, 2}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.separateSquares(squares)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.16667");
        System.out.println();
    }
}
