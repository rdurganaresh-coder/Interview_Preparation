package com.leetcode.graphs_shortest_path;

class Solution0797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(0));
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int u = path.get(path.size() - 1);
            if (u == n - 1) {
                ans.add(path);
                continue;
            }
            for (int v : graph[u]) {
                List<Integer> next = new ArrayList<>(path);
                next.add(v);
                queue.offer(next);
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
        Solution0797 _tcSol = new Solution0797();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "graph = [[1,2],[3],[3],[]]");
        try {
            int[][] graph = new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{3}, new int[]{}};
            System.out.println("  Output  : " + _tcShow(_tcSol.allPathsSourceTarget(graph)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1,3],[0,2,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "graph = [[4,3,1],[3,2,4],[3],[4],[]]");
        try {
            int[][] graph = new int[][]{new int[]{4, 3, 1}, new int[]{3, 2, 4}, new int[]{3}, new int[]{4}, new int[]{}};
            System.out.println("  Output  : " + _tcShow(_tcSol.allPathsSourceTarget(graph)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]");
        System.out.println();
    }
}