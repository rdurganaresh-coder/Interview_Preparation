package com.leetcode.arrays_hashing_greedy;

class Solution2493 {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        int[] d = new int[n];
        int[] dist = new int[n];
        for (int i = 0; i < n; ++i) {
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(i);
            Arrays.fill(dist, 0);
            dist[i] = 1;
            int mx = 1;
            int root = i;
            while (!q.isEmpty()) {
                int a = q.poll();
                root = Math.min(root, a);
                for (int b : g[a]) {
                    if (dist[b] == 0) {
                        dist[b] = dist[a] + 1;
                        mx = Math.max(mx, dist[b]);
                        q.offer(b);
                    } else if (Math.abs(dist[b] - dist[a]) != 1) {
                        return -1;
                    }
                }
            }
            d[root] = Math.max(d[root], mx);
        }
        return Arrays.stream(d).sum();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2493 _tcSol = new Solution2493();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 6}, new int[]{2, 3}, new int[]{4, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.magnificentSets(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[1,2],[2,3],[3,1]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.magnificentSets(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}