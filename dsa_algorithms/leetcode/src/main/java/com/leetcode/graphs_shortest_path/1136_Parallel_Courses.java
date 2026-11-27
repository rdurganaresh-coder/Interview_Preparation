package com.leetcode.graphs_shortest_path;

class Solution1136 {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[n];
        for (var r : relations) {
            int prev = r[0] - 1, nxt = r[1] - 1;
            g[prev].add(nxt);
            ++indeg[nxt];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            ++ans;
            for (int k = q.size(); k > 0; --k) {
                int i = q.poll();
                --n;
                for (int j : g[i]) {
                    if (--indeg[j] == 0) {
                        q.offer(j);
                    }
                }
            }
        }
        return n == 0 ? ans : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1136 _tcSol = new Solution1136();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, relations = [[1,3],[2,3]]");
        try {
            int n = 3;
            int[][] relations = new int[][]{new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSemesters(n, relations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, relations = [[1,2],[2,3],[3,1]]");
        try {
            int n = 3;
            int[][] relations = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSemesters(n, relations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}