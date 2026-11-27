package com.leetcode.arrays_hashing_greedy;

class Solution1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; ++i) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] q : qs) {
            while (i < n && intervals[i][0] <= q[0]) {
                int a = intervals[i][0], b = intervals[i][1];
                pq.offer(new int[] {b - a + 1, b});
                ++i;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[q[1]] = pq.peek()[0];
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
        Solution1851 _tcSol = new Solution1851();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 4}, new int[]{2, 4}, new int[]{3, 6}, new int[]{4, 4}};
            int[] queries = new int[]{2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minInterval(intervals, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,1,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]");
        try {
            int[][] intervals = new int[][]{new int[]{2, 3}, new int[]{2, 5}, new int[]{1, 8}, new int[]{20, 25}};
            int[] queries = new int[]{2, 19, 5, 22};
            System.out.println("  Output  : " + _tcShow(_tcSol.minInterval(intervals, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,-1,4,6]");
        System.out.println();
    }
}