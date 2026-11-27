package com.leetcode.graphs_shortest_path;

class Solution1466 {
    private List<int[]>[] g;

    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[] {b, 1});
            g[b].add(new int[] {a, 0});
        }
        return dfs(0, -1);
    }

    private int dfs(int a, int fa) {
        int ans = 0;
        for (var e : g[a]) {
            int b = e[0], c = e[1];
            if (b != fa) {
                ans += c + dfs(b, a);
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
        Solution1466 _tcSol = new Solution1466();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]");
        try {
            int n = 6;
            int[][] connections = new int[][]{new int[]{0, 1}, new int[]{1, 3}, new int[]{2, 3}, new int[]{4, 0}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minReorder(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]");
        try {
            int n = 5;
            int[][] connections = new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{3, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minReorder(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, connections = [[1,0],[2,0]]");
        try {
            int n = 3;
            int[][] connections = new int[][]{new int[]{1, 0}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minReorder(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
