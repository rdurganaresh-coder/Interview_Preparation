package com.leetcode.arrays_hashing_greedy;

class Solution0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; ++i) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;
        return merge(newIntervals);
    }

    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int s = intervals[i][0], e = intervals[i][1];
            if (ans.get(ans.size() - 1)[1] < s) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0057 _tcSol = new Solution0057();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,3],[6,9]], newInterval = [2,5]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{6, 9}};
            int[] newInterval = new int[]{2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.insert(intervals, newInterval)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,5],[6,9]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{3, 5}, new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16}};
            int[] newInterval = new int[]{4, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.insert(intervals, newInterval)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[3,10],[12,16]]");
        System.out.println();
    }
}