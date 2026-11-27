package com.leetcode.trees_tries;

class Solution0310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] degree = new int[n];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
            ++degree[a];
            ++degree[b];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.clear();
            for (int i = q.size(); i > 0; --i) {
                int a = q.poll();
                ans.add(a);
                for (int b : g[a]) {
                    if (--degree[b] == 1) {
                        q.offer(b);
                    }
                }
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
        Solution0310 _tcSol = new Solution0310();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[1,0],[1,2],[1,3]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinHeightTrees(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 4}, new int[]{5, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinHeightTrees(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();
    }
}