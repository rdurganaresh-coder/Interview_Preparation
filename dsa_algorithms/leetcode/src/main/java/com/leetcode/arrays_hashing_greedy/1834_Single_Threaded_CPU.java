package com.leetcode.arrays_hashing_greedy;

class Solution1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] ts = new int[n][3];
        for (int i = 0; i < n; ++i) {
            ts[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(ts, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        PriorityQueue<int[]> q
            = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int i = 0, t = 0, k = 0;
        while (!q.isEmpty() || i < n) {
            if (q.isEmpty()) {
                t = Math.max(t, ts[i][0]);
            }
            while (i < n && ts[i][0] <= t) {
                q.offer(new int[] {ts[i][1], ts[i][2]});
                ++i;
            }
            var p = q.poll();
            ans[k++] = p[1];
            t += p[0];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1834 _tcSol = new Solution1834();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [[1,2],[2,4],[3,2],[4,1]]");
        try {
            int[][] tasks = new int[][]{new int[]{1, 2}, new int[]{2, 4}, new int[]{3, 2}, new int[]{4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getOrder(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]");
        try {
            int[][] tasks = new int[][]{new int[]{7, 10}, new int[]{7, 12}, new int[]{7, 5}, new int[]{7, 4}, new int[]{7, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getOrder(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,3,2,0,1]");
        System.out.println();
    }
}