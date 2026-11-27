package com.leetcode.arrays_hashing_greedy;

class Solution0685 {
    private int[] p;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] ind = new int[n];
        for (var e : edges) {
            ++ind[e[1] - 1];
        }
        List<Integer> dup = new ArrayList<>();
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            if (ind[edges[i][1] - 1] == 2) {
                dup.add(i);
            }
            p[i] = i;
        }
        if (!dup.isEmpty()) {
            for (int i = 0; i < n; ++i) {
                if (i == dup.get(1)) {
                    continue;
                }
                int pu = find(edges[i][0] - 1);
                int pv = find(edges[i][1] - 1);
                if (pu == pv) {
                    return edges[dup.get(0)];
                }
                p[pu] = pv;
            }
            return edges[dup.get(1)];
        }
        for (int i = 0;; ++i) {
            int pu = find(edges[i][0] - 1);
            int pv = find(edges[i][1] - 1);
            if (pu == pv) {
                return edges[i];
            }
            p[pu] = pv;
        }
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
        Solution0685 _tcSol = new Solution0685();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[1,2],[1,3],[2,3]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRedundantDirectedConnection(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]");
        try {
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 1}, new int[]{1, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRedundantDirectedConnection(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,1]");
        System.out.println();
    }
}
