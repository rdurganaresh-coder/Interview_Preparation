package com.leetcode.arrays_hashing_greedy;

class Solution1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] f = new long[n];
        final int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; ++i) {
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + mod) % mod;
        }
        return (int) f[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1997 _tcSol = new Solution1997();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nextVisit = [0,0]");
        try {
            int[] nextVisit = new int[]{0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstDayBeenInAllRooms(nextVisit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nextVisit = [0,0,2]");
        try {
            int[] nextVisit = new int[]{0, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstDayBeenInAllRooms(nextVisit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nextVisit = [0,1,2,0]");
        try {
            int[] nextVisit = new int[]{0, 1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstDayBeenInAllRooms(nextVisit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}