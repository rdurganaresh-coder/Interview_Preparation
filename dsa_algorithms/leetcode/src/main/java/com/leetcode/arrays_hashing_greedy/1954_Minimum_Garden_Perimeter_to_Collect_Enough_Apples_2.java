package com.leetcode.arrays_hashing_greedy;

class Solution1954_2 {
    public long minimumPerimeter(long neededApples) {
        long l = 1, r = 100000;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l * 8;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1954_2 _tcSol = new Solution1954_2();
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