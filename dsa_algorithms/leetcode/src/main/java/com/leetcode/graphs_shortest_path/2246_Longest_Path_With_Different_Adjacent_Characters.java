package com.leetcode.graphs_shortest_path;

class Solution2246 {
    private List<Integer>[] g;
    private String s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        g = new List[n];
        this.s = s;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        dfs(0);
        return ans + 1;
    }

    private int dfs(int i) {
        int mx = 0;
        for (int j : g[i]) {
            int x = dfs(j) + 1;
            if (s.charAt(i) != s.charAt(j)) {
                ans = Math.max(ans, mx + x);
                mx = Math.max(mx, x);
            }
        }
        return mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2246 _tcSol = new Solution2246();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parent = [-1,0,0,1,1,2], s = \"abacbe\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 1, 1, 2};
            String s = "abacbe";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPath(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parent = [-1,0,0,0], s = \"aabc\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 0};
            String s = "aabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPath(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
