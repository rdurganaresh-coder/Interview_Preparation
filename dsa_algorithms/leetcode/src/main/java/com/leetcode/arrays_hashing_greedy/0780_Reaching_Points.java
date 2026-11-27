package com.leetcode.arrays_hashing_greedy;

class Solution0780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        }
        if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        }
        if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0780 _tcSol = new Solution0780();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sx = 1, sy = 1, tx = 3, ty = 5");
        try {
            int sx = 1;
            int sy = 1;
            int tx = 3;
            int ty = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachingPoints(sx, sy, tx, ty)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sx = 1, sy = 1, tx = 2, ty = 2");
        try {
            int sx = 1;
            int sy = 1;
            int tx = 2;
            int ty = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachingPoints(sx, sy, tx, ty)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sx = 1, sy = 1, tx = 1, ty = 1");
        try {
            int sx = 1;
            int sy = 1;
            int tx = 1;
            int ty = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachingPoints(sx, sy, tx, ty)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}