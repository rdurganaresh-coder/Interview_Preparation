package com.leetcode.arrays_hashing_greedy;

class Solution3275 {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.offer(x);
            if (i >= k) {
                pq.poll();
            }
            ans[i] = i >= k - 1 ? pq.peek() : -1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3275 _tcSol = new Solution3275();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [[1,2],[3,4],[2,3],[-3,0]], k = 2");
        try {
            int[][] queries = new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{2, 3}, new int[]{-3, 0}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultsArray(queries, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,7,5,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [[5,5],[4,4],[3,3]], k = 1");
        try {
            int[][] queries = new int[][]{new int[]{5, 5}, new int[]{4, 4}, new int[]{3, 3}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultsArray(queries, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,8,6]");
        System.out.println();
    }
}
