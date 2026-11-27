package com.leetcode.arrays_hashing_greedy;

class Solution3001 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != a || (d - b) * (d - f) > 0)) {
            return 1;
        }
        if (b == f && (d != b || (c - a) * (c - e) > 0)) {
            return 1;
        }
        if (c - e == d - f && (a - e != b - f || (a - c) * (a - e) > 0)) {
            return 1;
        }
        if (c - e == f - d && (a - e != f - b || (a - c) * (a - e) > 0)) {
            return 1;
        }
        return 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3001 _tcSol = new Solution3001();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 1, b = 1, c = 8, d = 8, e = 2, f = 3");
        try {
            int a = 1;
            int b = 1;
            int c = 8;
            int d = 8;
            int e = 2;
            int f = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToCaptureTheQueen(a, b, c, d, e, f)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 5, b = 3, c = 3, d = 4, e = 5, f = 2");
        try {
            int a = 5;
            int b = 3;
            int c = 3;
            int d = 4;
            int e = 5;
            int f = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToCaptureTheQueen(a, b, c, d, e, f)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
