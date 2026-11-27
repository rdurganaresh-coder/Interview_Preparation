package com.leetcode.graphs_shortest_path;

class Solution1697 {
    private int[] p;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int m = queries.length;
        boolean[] ans = new boolean[m];
        Integer[] qid = new Integer[m];
        for (int i = 0; i < m; ++i) {
            qid[i] = i;
        }
        Arrays.sort(qid, (i, j) -> queries[i][2] - queries[j][2]);
        int j = 0;
        for (int i : qid) {
            int a = queries[i][0], b = queries[i][1], limit = queries[i][2];
            while (j < edgeList.length && edgeList[j][2] < limit) {
                int u = edgeList[j][0], v = edgeList[j][1];
                p[find(u)] = find(v);
                ++j;
            }
            ans[i] = find(a) == find(b);
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1697 _tcSol = new Solution1697();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]");
        try {
            int n = 3;
            int[][] edgeList = new int[][]{new int[]{0, 1, 2}, new int[]{1, 2, 4}, new int[]{2, 0, 8}, new int[]{1, 0, 16}};
            int[][] queries = new int[][]{new int[]{0, 1, 2}, new int[]{0, 2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceLimitedPathsExist(n, edgeList, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]");
        try {
            int n = 5;
            int[][] edgeList = new int[][]{new int[]{0, 1, 10}, new int[]{1, 2, 5}, new int[]{2, 3, 9}, new int[]{3, 4, 13}};
            int[][] queries = new int[][]{new int[]{0, 4, 14}, new int[]{1, 4, 13}};
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceLimitedPathsExist(n, edgeList, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false]");
        System.out.println();
    }
}