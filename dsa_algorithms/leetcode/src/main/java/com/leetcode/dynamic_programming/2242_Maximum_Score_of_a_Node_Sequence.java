package com.leetcode.dynamic_programming;

class Solution2242 {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 0; i < n; ++i) {
            g[i].sort((a, b) -> scores[b] - scores[a]);
            g[i] = g[i].subList(0, Math.min(3, g[i].size()));
        }
        int ans = -1;
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            for (int c : g[a]) {
                for (int d : g[b]) {
                    if (c != b && c != d && a != d) {
                        int t = scores[a] + scores[b] + scores[c] + scores[d];
                        ans = Math.max(ans, t);
                    }
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
        Solution2242 _tcSol = new Solution2242();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "scores = [5,2,9,8,4], edges = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]");
        try {
            int[] scores = new int[]{5, 2, 9, 8, 4};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(scores, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "scores = [9,20,6,4,11,12], edges = [[0,3],[5,3],[2,4],[1,3]]");
        try {
            int[] scores = new int[]{9, 20, 6, 4, 11, 12};
            int[][] edges = new int[][]{new int[]{0, 3}, new int[]{5, 3}, new int[]{2, 4}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(scores, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}