package com.leetcode.arrays_hashing_greedy;

class Solution2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        int dx = Math.abs(sx - fx);
        int dy = Math.abs(sy - fy);
        return Math.max(dx, dy) <= t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2849 _tcSol = new Solution2849();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sx = 2, sy = 4, fx = 7, fy = 7, t = 6");
        try {
            int sx = 2;
            int sy = 4;
            int fx = 7;
            int fy = 7;
            int t = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.isReachableAtTime(sx, sy, fx, fy, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sx = 3, sy = 1, fx = 7, fy = 3, t = 3");
        try {
            int sx = 3;
            int sy = 1;
            int fx = 7;
            int fy = 3;
            int t = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.isReachableAtTime(sx, sy, fx, fy, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}