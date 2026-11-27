package com.leetcode.arrays_hashing_greedy;

class Solution1824 {
    public int minSideJumps(int[] obstacles) {
        final int inf = 1 << 30;
        int[] f = {1, 0, 1};
        for (int i = 1; i < obstacles.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] == j + 1) {
                    f[j] = inf;
                    break;
                }
            }
            int x = Math.min(f[0], Math.min(f[1], f[2])) + 1;
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] != j + 1) {
                    f[j] = Math.min(f[j], x);
                }
            }
        }
        return Math.min(f[0], Math.min(f[1], f[2]));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1824 _tcSol = new Solution1824();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "obstacles = [0,1,2,3,0]");
        try {
            int[] obstacles = new int[]{0, 1, 2, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSideJumps(obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "obstacles = [0,1,1,3,3,0]");
        try {
            int[] obstacles = new int[]{0, 1, 1, 3, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSideJumps(obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "obstacles = [0,2,1,0,3,0]");
        try {
            int[] obstacles = new int[]{0, 2, 1, 0, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSideJumps(obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}