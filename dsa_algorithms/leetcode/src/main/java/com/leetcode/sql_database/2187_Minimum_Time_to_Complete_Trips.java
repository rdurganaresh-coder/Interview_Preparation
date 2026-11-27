package com.leetcode.sql_database;

class Solution2187 {
    public long minimumTime(int[] time, int totalTrips) {
        int mi = time[0];
        for (int v : time) {
            mi = Math.min(mi, v);
        }
        long left = 1, right = (long) mi * totalTrips;
        while (left < right) {
            long cnt = 0;
            long mid = (left + right) >> 1;
            for (int v : time) {
                cnt += mid / v;
            }
            if (cnt >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2187 _tcSol = new Solution2187();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "time = [1,2,3], totalTrips = 5");
        try {
            int[] time = new int[]{1, 2, 3};
            int totalTrips = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(time, totalTrips)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "time = [2], totalTrips = 1");
        try {
            int[] time = new int[]{2};
            int totalTrips = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(time, totalTrips)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}