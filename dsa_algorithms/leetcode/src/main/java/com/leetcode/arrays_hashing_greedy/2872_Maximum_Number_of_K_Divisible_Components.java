package com.leetcode.arrays_hashing_greedy;

class Solution2872 {
    private int ans;
    private List<Integer>[] g;
    private int[] values;
    private int k;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        this.values = values;
        this.k = k;
        dfs(0, -1);
        return ans;
    }

    private long dfs(int i, int fa) {
        long s = values[i];
        for (int j : g[i]) {
            if (j != fa) {
                s += dfs(j, i);
            }
        }
        ans += s % k == 0 ? 1 : 0;
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2872 _tcSol = new Solution2872();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 2}, new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}};
            int[] values = new int[]{1, 8, 1, 4, 4};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxKDivisibleComponents(n, edges, values, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}, new int[]{2, 6}};
            int[] values = new int[]{3, 0, 6, 1, 5, 2, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxKDivisibleComponents(n, edges, values, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
