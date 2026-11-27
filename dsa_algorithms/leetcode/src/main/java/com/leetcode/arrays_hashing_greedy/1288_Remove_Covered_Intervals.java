package com.leetcode.arrays_hashing_greedy;

class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0, pre = Integer.MIN_VALUE;
        for (var e : intervals) {
            int cur = e[1];
            if (cur > pre) {
                ++ans;
                pre = cur;
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
        Solution1288 _tcSol = new Solution1288();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,4],[3,6],[2,8]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 4}, new int[]{3, 6}, new int[]{2, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeCoveredIntervals(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[1,4],[2,3]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 4}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeCoveredIntervals(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
