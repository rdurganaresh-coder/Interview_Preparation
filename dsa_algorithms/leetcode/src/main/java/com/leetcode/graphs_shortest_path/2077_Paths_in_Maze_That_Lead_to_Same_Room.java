package com.leetcode.graphs_shortest_path;

class Solution2077 {
    public int numberOfPaths(int n, int[][] corridors) {
        Set<Integer>[] g = new Set[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new HashSet<>();
        }
        for (var c : corridors) {
            int a = c[0], b = c[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        for (int c = 1; c <= n; ++c) {
            var nxt = new ArrayList<>(g[c]);
            int m = nxt.size();
            for (int i = 0; i < m; ++i) {
                for (int j = i + 1; j < m; ++j) {
                    int a = nxt.get(i), b = nxt.get(j);
                    if (g[b].contains(a)) {
                        ++ans;
                    }
                }
            }
        }
        return ans / 3;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2077 _tcSol = new Solution2077();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, corridors = [[1,2],[5,2],[4,1],[2,4],[3,1],[3,4]]");
        try {
            int n = 5;
            int[][] corridors = new int[][]{new int[]{1, 2}, new int[]{5, 2}, new int[]{4, 1}, new int[]{2, 4}, new int[]{3, 1}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPaths(n, corridors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, corridors = [[1,2],[3,4]]");
        try {
            int n = 4;
            int[][] corridors = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPaths(n, corridors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}