package com.leetcode.arrays_hashing_greedy;

class Solution2581_2 {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Map<Long, Integer> gs = new HashMap<>();
        for (var e : guesses) {
            gs.merge(1L * e[0] * n + e[1], 1, Integer::sum);
        }
        int cnt = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1];
            for (int j : g[i]) {
                if (j != fa) {
                    cnt += gs.getOrDefault(1L * i * n + j, 0);
                    stk.push(new int[] {j, i});
                }
            }
        }
        int ans = 0;
        Deque<int[]> walk = new ArrayDeque<>();
        walk.push(new int[] {0, -1, cnt});
        while (!walk.isEmpty()) {
            int[] cur = walk.pop();
            int i = cur[0], fa = cur[1], c = cur[2];
            if (c >= k) {
                ++ans;
            }
            for (int j : g[i]) {
                if (j != fa) {
                    int a = gs.getOrDefault(1L * i * n + j, 0);
                    int b = gs.getOrDefault(1L * j * n + i, 0);
                    walk.push(new int[] {j, i, c - a + b});
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
        Solution2581_2 _tcSol = new Solution2581_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{4, 2}};
            int[][] guesses = new int[][]{new int[]{1, 3}, new int[]{0, 1}, new int[]{1, 0}, new int[]{2, 4}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.rootCount(edges, guesses, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}};
            int[][] guesses = new int[][]{new int[]{1, 0}, new int[]{3, 4}, new int[]{2, 1}, new int[]{3, 2}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.rootCount(edges, guesses, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
