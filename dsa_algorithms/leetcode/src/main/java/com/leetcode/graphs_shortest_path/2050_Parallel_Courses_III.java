package com.leetcode.graphs_shortest_path;

class Solution2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] e : relations) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            ++indeg[b];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int[] f = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int v = indeg[i], t = time[i];
            if (v == 0) {
                q.offer(i);
                f[i] = t;
                ans = Math.max(ans, t);
            }
        }
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            for (int j : g[i]) {
                f[j] = Math.max(f[j], f[i] + time[j]);
                ans = Math.max(ans, f[j]);
                if (--indeg[j] == 0) {
                    q.offer(j);
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
        Solution2050 _tcSol = new Solution2050();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, relations = [[1,3],[2,3]], time = [3,2,5]");
        try {
            int n = 3;
            int[][] relations = new int[][]{new int[]{1, 3}, new int[]{2, 3}};
            int[] time = new int[]{3, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(n, relations, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]");
        try {
            int n = 5;
            int[][] relations = new int[][]{new int[]{1, 5}, new int[]{2, 5}, new int[]{3, 5}, new int[]{3, 4}, new int[]{4, 5}};
            int[] time = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(n, relations, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}