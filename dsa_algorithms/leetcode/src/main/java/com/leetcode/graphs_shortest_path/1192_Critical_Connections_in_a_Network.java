package com.leetcode.graphs_shortest_path;

class Solution1192 {
    private int now;
    private List<Integer>[] g;
    private List<List<Integer>> ans = new ArrayList<>();
    private int[] dfn;
    private int[] low;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        dfn = new int[n];
        low = new int[n];
        for (var e : connections) {
            int a = e.get(0), b = e.get(1);
            g[a].add(b);
            g[b].add(a);
        }
        tarjan(0, -1);
        return ans;
    }

    private void tarjan(int a, int fa) {
        dfn[a] = low[a] = ++now;
        for (int b : g[a]) {
            if (b == fa) {
                continue;
            }
            if (dfn[b] == 0) {
                tarjan(b, a);
                low[a] = Math.min(low[a], low[b]);
                if (low[b] > dfn[a]) {
                    ans.add(List.of(a, b));
                }
            } else {
                low[a] = Math.min(low[a], dfn[b]);
            }
        }
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
        Solution1192 _tcSol = new Solution1192();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]");
        try {
            int n = 4;
            List<List<Integer>> connections = _tcL(_tcL(0, 1), _tcL(1, 2), _tcL(2, 0), _tcL(1, 3));
            System.out.println("  Output  : " + _tcShow(_tcSol.criticalConnections(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, connections = [[0,1]]");
        try {
            int n = 2;
            List<List<Integer>> connections = _tcL(_tcL(0, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.criticalConnections(n, connections)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1]]");
        System.out.println();
    }
}