package com.leetcode.graphs_shortest_path;

class Solution3493 {
    private List<Integer>[] g;
    private boolean[] vis;

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        g = new List[n];
        Set<Integer>[] ss = new Set[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        Arrays.setAll(ss, i -> new HashSet<>());
        for (int i = 0; i < n; ++i) {
            for (int x : properties[i]) {
                ss[i].add(x);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int cnt = 0;
                for (int x : ss[i]) {
                    if (ss[j].contains(x)) {
                        ++cnt;
                    }
                }
                if (cnt >= k) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }

        int ans = 0;
        vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                dfs(i);
                ++ans;
            }
        }
        return ans;
    }

    private void dfs(int i) {
        vis[i] = true;
        for (int j : g[i]) {
            if (!vis[j]) {
                dfs(j);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3493 _tcSol = new Solution3493();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "properties = [[1,2],[1,1],[3,4],[4,5],[5,6],[7,7]], k = 1");
        try {
            int[][] properties = new int[][]{new int[]{1, 2}, new int[]{1, 1}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 6}, new int[]{7, 7}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfComponents(properties, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "properties = [[1,2,3],[2,3,4],[4,3,5]], k = 2");
        try {
            int[][] properties = new int[][]{new int[]{1, 2, 3}, new int[]{2, 3, 4}, new int[]{4, 3, 5}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfComponents(properties, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "properties = [[1,1],[1,1]], k = 2");
        try {
            int[][] properties = new int[][]{new int[]{1, 1}, new int[]{1, 1}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfComponents(properties, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
