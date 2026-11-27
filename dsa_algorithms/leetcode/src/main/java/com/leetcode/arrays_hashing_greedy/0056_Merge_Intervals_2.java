package com.leetcode.arrays_hashing_greedy;

class Solution0056_2 {
    public int[][] merge(int[][] intervals) {
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
        Solution0056_2 _tcSol = new Solution0056_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,3],[2,6],[8,10],[15,18]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
            System.out.println("  Output  : " + _tcShow(_tcSol.merge(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,6],[8,10],[15,18]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[1,4],[4,5]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 4}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.merge(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,5]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "intervals = [[4,7],[1,4]]");
        try {
            int[][] intervals = new int[][]{new int[]{4, 7}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.merge(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,7]]");
        System.out.println();
    }
}