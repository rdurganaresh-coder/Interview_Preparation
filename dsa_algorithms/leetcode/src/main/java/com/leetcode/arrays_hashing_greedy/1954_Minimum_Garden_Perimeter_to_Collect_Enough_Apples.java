package com.leetcode.arrays_hashing_greedy;

class Solution1954 {
    public long minimumPerimeter(long neededApples) {
        long x = 1;
        while (2 * x * (x + 1) * (2 * x + 1) < neededApples) {
            ++x;
        }
        return 8 * x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1954 _tcSol = new Solution1954();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "neededApples = 1");
        try {
            long neededApples = 1L;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPerimeter(neededApples)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "neededApples = 13");
        try {
            long neededApples = 13L;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPerimeter(neededApples)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "neededApples = 1000000000");
        try {
            long neededApples = 1000000000L;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPerimeter(neededApples)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5040");
        System.out.println();
    }
}