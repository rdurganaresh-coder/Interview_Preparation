package com.leetcode.sql_database;

class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; ++i) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1450 _tcSol = new Solution1450();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startTime = [1,2,3], endTime = [3,2,7], queryTime = 4");
        try {
            int[] startTime = new int[]{1, 2, 3};
            int[] endTime = new int[]{3, 2, 7};
            int queryTime = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.busyStudent(startTime, endTime, queryTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startTime = [4], endTime = [4], queryTime = 4");
        try {
            int[] startTime = new int[]{4};
            int[] endTime = new int[]{4};
            int queryTime = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.busyStudent(startTime, endTime, queryTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}