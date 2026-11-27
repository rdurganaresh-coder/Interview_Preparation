package com.leetcode.arrays_hashing_greedy;

class Solution0435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = intervals.length;
        int pre = Integer.MIN_VALUE;
        for (var e : intervals) {
            int l = e[0], r = e[1];
            if (pre <= l) {
                --ans;
                pre = r;
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
        Solution0435 _tcSol = new Solution0435();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,2],[2,3],[3,4],[1,3]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.eraseOverlapIntervals(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[1,2],[1,2],[1,2]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.eraseOverlapIntervals(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "intervals = [[1,2],[2,3]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.eraseOverlapIntervals(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
