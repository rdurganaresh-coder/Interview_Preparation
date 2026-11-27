package com.leetcode.arrays_hashing_greedy;

class Solution0802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indeg = new int[n];
        List<Integer>[] rg = new List[n];
        Arrays.setAll(rg, k -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            for (int j : graph[i]) {
                rg[j].add(i);
            }
            indeg[i] = graph[i].length;
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            for (int j : rg[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                ans.add(i);
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
        Solution0802 _tcSol = new Solution0802();
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