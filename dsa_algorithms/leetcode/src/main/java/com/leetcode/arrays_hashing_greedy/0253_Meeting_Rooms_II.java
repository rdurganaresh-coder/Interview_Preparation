package com.leetcode.arrays_hashing_greedy;

class Solution0253 {
    public int minMeetingRooms(int[][] intervals) {
        int m = 0;
        for (var e : intervals) {
            m = Math.max(m, e[1]);
        }
        int[] d = new int[m + 1];
        for (var e : intervals) {
            ++d[e[0]];
            --d[e[1]];
        }
        int ans = 0, s = 0;
        for (int v : d) {
            s += v;
            ans = Math.max(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0253 _tcSol = new Solution0253();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[0,30],[5,10],[15,20]]");
        try {
            int[][] intervals = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMeetingRooms(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[7,10],[2,4]]");
        try {
            int[][] intervals = new int[][]{new int[]{7, 10}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMeetingRooms(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
