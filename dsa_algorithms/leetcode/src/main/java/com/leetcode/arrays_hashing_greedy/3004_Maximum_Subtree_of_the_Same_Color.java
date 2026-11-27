package com.leetcode.arrays_hashing_greedy;

class Solution3004 {
    private List<Integer>[] g;
    private int[] colors;
    private int[] size;
    private int ans;

    public int maximumSubtreeSize(int[][] edges, int[] colors) {
        int n = edges.length + 1;
        g = new List[n];
        size = new int[n];
        this.colors = colors;
        Arrays.fill(size, 1);
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private boolean dfs(int a, int fa) {
        boolean ok = true;
        for (int b : g[a]) {
            if (b != fa) {
                boolean t = dfs(b, a);
                ok = ok && colors[a] == colors[b] && t;
                size[a] += size[b];
            }
        }
        if (ok) {
            ans = Math.max(ans, size[a]);
        }
        return ok;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3004 _tcSol = new Solution3004();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3]], colors = [1,1,2,3]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            int[] colors = new int[]{1, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubtreeSize(edges, colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3]], colors = [1,1,1,1]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            int[] colors = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubtreeSize(edges, colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[2,3],[2,4]], colors = [1,2,3,3,3]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}};
            int[] colors = new int[]{1, 2, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubtreeSize(edges, colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
