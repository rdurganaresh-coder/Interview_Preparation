package com.leetcode.arrays_hashing_greedy;

class Solution0849 {
    public int maxDistToClosest(int[] seats) {
        int first = -1, last = -1;
        int d = 0, n = seats.length;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                if (last != -1) {
                    d = Math.max(d, i - last);
                }
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return Math.max(d / 2, Math.max(first, n - last - 1));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0849 _tcSol = new Solution0849();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "seats = [1,0,0,0,1,0,1]");
        try {
            int[] seats = new int[]{1, 0, 0, 0, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistToClosest(seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "seats = [1,0,0,0]");
        try {
            int[] seats = new int[]{1, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistToClosest(seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "seats = [0,1]");
        try {
            int[] seats = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistToClosest(seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}