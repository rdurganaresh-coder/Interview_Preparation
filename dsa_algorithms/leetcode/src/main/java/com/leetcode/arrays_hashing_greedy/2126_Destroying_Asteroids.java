package com.leetcode.arrays_hashing_greedy;

class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int x : asteroids) {
            if (m < x) {
                return false;
            }
            m += x;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2126 _tcSol = new Solution2126();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mass = 10, asteroids = [3,9,19,5,21]");
        try {
            int mass = 10;
            int[] asteroids = new int[]{3, 9, 19, 5, 21};
            System.out.println("  Output  : " + _tcShow(_tcSol.asteroidsDestroyed(mass, asteroids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mass = 5, asteroids = [4,9,23,4]");
        try {
            int mass = 5;
            int[] asteroids = new int[]{4, 9, 23, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.asteroidsDestroyed(mass, asteroids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
