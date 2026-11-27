package com.leetcode.arrays_hashing_greedy;

class Solution0057_2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int st = newInterval[0], ed = newInterval[1];
        boolean insert = false;
        for (int[] interval : intervals) {
            int s = interval[0], e = interval[1];
            if (ed < s) {
                if (!insert) {
                    ans.add(new int[] {st, ed});
                    insert = true;
                }
                ans.add(interval);
            } else if (e < st) {
                ans.add(interval);
            } else {
                st = Math.min(st, s);
                ed = Math.max(ed, e);
            }
        }
        if (!insert) {
            ans.add(new int[] {st, ed});
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0057_2 _tcSol = new Solution0057_2();
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