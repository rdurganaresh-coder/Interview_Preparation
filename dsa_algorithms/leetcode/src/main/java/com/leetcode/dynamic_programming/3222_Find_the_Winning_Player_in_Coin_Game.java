package com.leetcode.dynamic_programming;

class Solution3222 {
    public String losingPlayer(int x, int y) {
        int k = Math.min(x / 2, y / 8);
        x -= k * 2;
        y -= k * 8;
        return x > 0 && y >= 4 ? "Alice" : "Bob";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3222 _tcSol = new Solution3222();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 2, y = 7");
        try {
            int x = 2;
            int y = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.losingPlayer(x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Alice\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 4, y = 11");
        try {
            int x = 4;
            int y = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.losingPlayer(x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Bob\"");
        System.out.println();
    }
}