package com.leetcode.arrays_hashing_greedy;

class Solution0802_2 {
    private int[] color;
    private int[][] g;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        g = graph;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (dfs(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int i) {
        if (color[i] > 0) {
            return color[i] == 2;
        }
        color[i] = 1;
        for (int j : g[i]) {
            if (!dfs(j)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0802_2 _tcSol = new Solution0802_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "graph = [[1,2],[2,3],[5],[0],[5],[],[]]");
        try {
            int[][] graph = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{5}, new int[]{0}, new int[]{5}, new int[]{}, new int[]{}};
            System.out.println("  Output  : " + _tcShow(_tcSol.eventualSafeNodes(graph)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,5,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]");
        try {
            int[][] graph = new int[][]{new int[]{1, 2, 3, 4}, new int[]{1, 2}, new int[]{3, 4}, new int[]{0, 4}, new int[]{}};
            System.out.println("  Output  : " + _tcShow(_tcSol.eventualSafeNodes(graph)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4]");
        System.out.println();
    }
}