package com.leetcode.graphs_shortest_path;

class Solution3244 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] nxt = new int[n - 1];
        for (int i = 1; i < n; ++i) {
            nxt[i - 1] = i;
        }
        int m = queries.length;
        int cnt = n - 1;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int u = queries[i][0], v = queries[i][1];
            if (nxt[u] > 0 && nxt[u] < v) {
                int j = nxt[u];
                while (j < v) {
                    --cnt;
                    int t = nxt[j];
                    nxt[j] = 0;
                    j = t;
                }
                nxt[u] = v;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3244 _tcSol = new Solution3244();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, queries = [[2,4],[0,2],[0,4]]");
        try {
            int n = 5;
            int[][] queries = new int[][]{new int[]{2, 4}, new int[]{0, 2}, new int[]{0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistanceAfterQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, queries = [[0,3],[0,2]]");
        try {
            int n = 4;
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistanceAfterQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}
