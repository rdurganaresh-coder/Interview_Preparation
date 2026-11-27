package com.leetcode.arrays_hashing_greedy;

class Solution2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (var e : intervals) {
            if (!q.isEmpty() && q.peek() < e[0]) {
                q.poll();
            }
            q.offer(e[1]);
        }
        return q.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2406 _tcSol = new Solution2406();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]");
        try {
            int[][] intervals = new int[][]{new int[]{5, 10}, new int[]{6, 8}, new int[]{1, 5}, new int[]{2, 3}, new int[]{1, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minGroups(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[1,3],[5,6],[8,10],[11,13]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{5, 6}, new int[]{8, 10}, new int[]{11, 13}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minGroups(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}