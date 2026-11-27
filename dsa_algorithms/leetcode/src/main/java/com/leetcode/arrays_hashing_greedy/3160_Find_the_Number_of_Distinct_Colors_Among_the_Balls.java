package com.leetcode.arrays_hashing_greedy;

class Solution3160 {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> g = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int x = queries[i][0], y = queries[i][1];
            cnt.merge(y, 1, Integer::sum);
            if (g.containsKey(x) && cnt.merge(g.get(x), -1, Integer::sum) == 0) {
                cnt.remove(g.get(x));
            }
            g.put(x, y);
            ans[i] = cnt.size();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3160 _tcSol = new Solution3160();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]");
        try {
            int limit = 4;
            int[][] queries = new int[][]{new int[]{1, 4}, new int[]{2, 5}, new int[]{1, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.queryResults(limit, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]");
        try {
            int limit = 4;
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 4}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.queryResults(limit, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2,3,4]");
        System.out.println();
    }
}