package com.leetcode.arrays_hashing_greedy;

class Solution2858_2 {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(new int[] {y, 1});
            g[y].add(new int[] {x, -1});
        }
        int[] ans = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1];
            for (var ne : g[i]) {
                int j = ne[0], k = ne[1];
                if (j != fa) {
                    ans[0] += k < 0 ? 1 : 0;
                    stk.push(new int[] {j, i});
                }
            }
        }
        stk.push(new int[] {0, -1});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1];
            for (var ne : g[i]) {
                int j = ne[0], k = ne[1];
                if (j != fa) {
                    ans[j] = ans[i] + k;
                    stk.push(new int[] {j, i});
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
        Solution2858_2 _tcSol = new Solution2858_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[2,0],[2,1],[1,3]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{2, 0}, new int[]{2, 1}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minEdgeReversals(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[1,2],[2,0]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minEdgeReversals(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,1]");
        System.out.println();
    }
}
