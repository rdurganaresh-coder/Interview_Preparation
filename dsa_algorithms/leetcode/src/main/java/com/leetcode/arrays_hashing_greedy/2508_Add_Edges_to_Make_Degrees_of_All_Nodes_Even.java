package com.leetcode.arrays_hashing_greedy;

class Solution2508 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Set<Integer>[] g = new Set[n + 1];
        Arrays.setAll(g, k -> new HashSet<>());
        for (var e : edges) {
            int a = e.get(0), b = e.get(1);
            g[a].add(b);
            g[b].add(a);
        }
        List<Integer> vs = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (g[i].size() % 2 == 1) {
                vs.add(i);
            }
        }
        if (vs.size() == 0) {
            return true;
        }
        if (vs.size() == 2) {
            int a = vs.get(0), b = vs.get(1);
            if (!g[a].contains(b)) {
                return true;
            }
            for (int c = 1; c <= n; ++c) {
                if (a != c && b != c && !g[a].contains(c) && !g[c].contains(b)) {
                    return true;
                }
            }
            return false;
        }
        if (vs.size() == 4) {
            int a = vs.get(0), b = vs.get(1), c = vs.get(2), d = vs.get(3);
            if (!g[a].contains(b) && !g[c].contains(d)) {
                return true;
            }
            if (!g[a].contains(c) && !g[b].contains(d)) {
                return true;
            }
            if (!g[a].contains(d) && !g[b].contains(c)) {
                return true;
            }
            return false;
        }
        return false;
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
        Solution2508 _tcSol = new Solution2508();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]");
        try {
            int n = 5;
            List<List<Integer>> edges = _tcL(_tcL(1, 2), _tcL(2, 3), _tcL(3, 4), _tcL(4, 2), _tcL(1, 4), _tcL(2, 5));
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[1,2],[3,4]]");
        try {
            int n = 4;
            List<List<Integer>> edges = _tcL(_tcL(1, 2), _tcL(3, 4));
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, edges = [[1,2],[1,3],[1,4]]");
        try {
            int n = 4;
            List<List<Integer>> edges = _tcL(_tcL(1, 2), _tcL(1, 3), _tcL(1, 4));
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}