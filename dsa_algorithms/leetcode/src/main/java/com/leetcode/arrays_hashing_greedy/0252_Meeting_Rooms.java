package com.leetcode.arrays_hashing_greedy;

class Solution0252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i - 1][1] > intervals[i][0]) {
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
        Solution0252 _tcSol = new Solution0252();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[0,30],[5,10],[15,20]]");
        try {
            int[][] intervals = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAttendMeetings(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[7,10],[2,4]]");
        try {
            int[][] intervals = new int[][]{new int[]{7, 10}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAttendMeetings(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
