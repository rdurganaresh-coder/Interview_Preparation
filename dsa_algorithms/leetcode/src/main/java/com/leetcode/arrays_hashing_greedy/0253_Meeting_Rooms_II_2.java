package com.leetcode.arrays_hashing_greedy;

class Solution0253_2 {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> d = new TreeMap<>();
        for (var e : intervals) {
            d.merge(e[0], 1, Integer::sum);
            d.merge(e[1], -1, Integer::sum);
        }
        int ans = 0, s = 0;
        for (var e : d.values()) {
            s += e;
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
        Solution0253_2 _tcSol = new Solution0253_2();
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
