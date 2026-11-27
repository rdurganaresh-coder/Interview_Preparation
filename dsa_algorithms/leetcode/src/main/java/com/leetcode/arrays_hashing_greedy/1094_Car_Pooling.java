package com.leetcode.arrays_hashing_greedy;

class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (var trip : trips) {
            int x = trip[0], f = trip[1], t = trip[2];
            d[f] += x;
            d[t] -= x;
        }
        int s = 0;
        for (int x : d) {
            s += x;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1094 _tcSol = new Solution1094();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "trips = [[2,1,5],[3,3,7]], capacity = 4");
        try {
            int[][] trips = new int[][]{new int[]{2, 1, 5}, new int[]{3, 3, 7}};
            int capacity = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.carPooling(trips, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "trips = [[2,1,5],[3,3,7]], capacity = 5");
        try {
            int[][] trips = new int[][]{new int[]{2, 1, 5}, new int[]{3, 3, 7}};
            int capacity = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.carPooling(trips, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}