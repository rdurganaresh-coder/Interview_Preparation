package com.leetcode.trees_tries;

class Solution1443_2 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int[] cost = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int u = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {u, fa, 1});
                for (int v : g[u]) {
                    if (v != fa) {
                        stk.push(new int[] {v, u, 0});
                    }
                }
            } else {
                int nxt = 0;
                for (int v : g[u]) {
                    if (v != fa) {
                        nxt += cost[v];
                    }
                }
                if (hasApple.get(u) || nxt > 0) {
                    cost[u] = u == 0 ? nxt : nxt + 2;
                }
            }
        }
        return cost[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution1443_2 _tcSol = new Solution1443_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 6}};
            List<Boolean> hasApple = _tcL(false, false, true, false, true, true, false);
            System.out.println("  Output  : " + _tcShow(_tcSol.minTime(n, edges, hasApple)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 6}};
            List<Boolean> hasApple = _tcL(false, false, true, false, false, true, false);
            System.out.println("  Output  : " + _tcShow(_tcSol.minTime(n, edges, hasApple)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 6}};
            List<Boolean> hasApple = _tcL(false, false, false, false, false, false, false);
            System.out.println("  Output  : " + _tcShow(_tcSol.minTime(n, edges, hasApple)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
