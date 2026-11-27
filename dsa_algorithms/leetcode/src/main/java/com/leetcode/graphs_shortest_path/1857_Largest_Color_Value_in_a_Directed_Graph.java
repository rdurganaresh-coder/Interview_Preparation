package com.leetcode.graphs_shortest_path;

class Solution1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            ++indeg[b];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
                int c = colors.charAt(i) - 'a';
                ++dp[i][c];
            }
        }
        int cnt = 0;
        int ans = 1;
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            ++cnt;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
                int c = colors.charAt(j) - 'a';
                for (int k = 0; k < 26; ++k) {
                    dp[j][k] = Math.max(dp[j][k], dp[i][k] + (c == k ? 1 : 0));
                    ans = Math.max(ans, dp[j][k]);
                }
            }
        }
        return cnt == n ? ans : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1857 _tcSol = new Solution1857();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "colors = \"abaca\", edges = [[0,1],[0,2],[2,3],[3,4]]");
        try {
            String colors = "abaca";
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPathValue(colors, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "colors = \"a\", edges = [[0,0]]");
        try {
            String colors = "a";
            int[][] edges = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPathValue(colors, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}