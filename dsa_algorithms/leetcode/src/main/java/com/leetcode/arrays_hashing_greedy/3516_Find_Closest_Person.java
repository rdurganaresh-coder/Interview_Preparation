package com.leetcode.arrays_hashing_greedy;

class Solution3516 {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        return a == b ? 0 : (a < b ? 1 : 2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3516 _tcSol = new Solution3516();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 2, y = 7, z = 4");
        try {
            int x = 2;
            int y = 7;
            int z = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosest(x, y, z)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 2, y = 5, z = 6");
        try {
            int x = 2;
            int y = 5;
            int z = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosest(x, y, z)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 1, y = 5, z = 3");
        try {
            int x = 1;
            int y = 5;
            int z = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosest(x, y, z)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}