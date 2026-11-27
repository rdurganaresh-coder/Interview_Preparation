package com.leetcode.graphs_shortest_path;

class Solution1135 {
    private int[] p;

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int ans = 0;
        for (int[] e : connections) {
            int x = e[0] - 1, y = e[1] - 1, cost = e[2];
            if (find(x) == find(y)) {
                continue;
            }
            p[find(x)] = find(y);
            ans += cost;
            if (--n == 1) {
                return ans;
            }
        }
        return -1;
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
        Solution1135 _tcSol = new Solution1135();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]");
        try {
            int n = 3;
            int[][] connections = new int[][]{new int[]{1, 2, 5}, new int[]{1, 3, 6}, new int[]{2, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, connections = [[1,2,3],[3,4,4]]");
        try {
            int n = 4;
            int[][] connections = new int[][]{new int[]{1, 2, 3}, new int[]{3, 4, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}