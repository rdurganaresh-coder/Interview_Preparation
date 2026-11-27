package com.leetcode.arrays_hashing_greedy;

class Solution2931 {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; ++i) {
            pq.offer(new int[] {values[i][n - 1], i, n - 1});
        }
        long ans = 0;
        for (int d = 1; !pq.isEmpty(); ++d) {
            var p = pq.poll();
            int v = p[0], i = p[1], j = p[2];
            ans += (long) v * d;
            if (j > 0) {
                pq.offer(new int[] {values[i][j - 1], i, j - 1});
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
        Solution2931 _tcSol = new Solution2931();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "values = [[8,5,2],[6,4,1],[9,7,3]]");
        try {
            int[][] values = new int[][]{new int[]{8, 5, 2}, new int[]{6, 4, 1}, new int[]{9, 7, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSpending(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "285");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "values = [[10,8,6,4,2],[9,7,5,3,2]]");
        try {
            int[][] values = new int[][]{new int[]{10, 8, 6, 4, 2}, new int[]{9, 7, 5, 3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSpending(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "386");
        System.out.println();
    }
}