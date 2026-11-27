package com.leetcode.sliding_window_two_pointers;

class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;
        int mi = 0, mx = 0;
        if (z - x > 2) {
            mi = y - x < 3 || z - y < 3 ? 1 : 2;
            mx = z - x - 2;
        }
        return new int[] {mi, mx};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1033 _tcSol = new Solution1033();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 1, b = 2, c = 5");
        try {
            int a = 1;
            int b = 2;
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numMovesStones(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 4, b = 3, c = 2");
        try {
            int a = 4;
            int b = 3;
            int c = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numMovesStones(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = 3, b = 5, c = 1");
        try {
            int a = 3;
            int b = 5;
            int c = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numMovesStones(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}