package com.leetcode.strings;

class Solution2745 {
    public int longestString(int x, int y, int z) {
        if (x < y) {
            return (x * 2 + z + 1) * 2;
        }
        if (x > y) {
            return (y * 2 + z + 1) * 2;
        }
        return (x + y + z) * 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2745 _tcSol = new Solution2745();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 2, y = 5, z = 1");
        try {
            int x = 2;
            int y = 5;
            int z = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestString(x, y, z)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 3, y = 2, z = 2");
        try {
            int x = 3;
            int y = 2;
            int z = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestString(x, y, z)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();
    }
}