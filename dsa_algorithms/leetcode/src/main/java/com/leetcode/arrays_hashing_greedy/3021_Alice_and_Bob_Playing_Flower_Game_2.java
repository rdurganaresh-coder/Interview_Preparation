package com.leetcode.arrays_hashing_greedy;

class Solution3021_2 {
    public long flowerGame(int n, int m) {
        return ((long) n * m) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3021_2 _tcSol = new Solution3021_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, m = 2");
        try {
            int n = 3;
            int m = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.flowerGame(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, m = 1");
        try {
            int n = 1;
            int m = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.flowerGame(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}