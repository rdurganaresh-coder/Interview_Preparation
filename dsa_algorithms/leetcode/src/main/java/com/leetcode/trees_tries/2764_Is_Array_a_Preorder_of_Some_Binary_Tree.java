package com.leetcode.trees_tries;

class Solution2764 {
    private Map<Integer, List<Integer>> g = new HashMap<>();
    private List<List<Integer>> nodes;
    private int k;

    public boolean isPreorder(List<List<Integer>> nodes) {
        this.nodes = nodes;
        for (var node : nodes) {
            g.computeIfAbsent(node.get(1), key -> new ArrayList<>()).add(node.get(0));
        }
        return dfs(nodes.get(0).get(0)) && k == nodes.size();
    }

    private boolean dfs(int i) {
        if (i != nodes.get(k).get(0)) {
            return false;
        }
        ++k;
        for (int j : g.getOrDefault(i, List.of())) {
            if (!dfs(j)) {
                return false;
            }
        }
        return true;
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
        Solution2764 _tcSol = new Solution2764();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nodes = [[0,-1],[1,0],[2,0],[3,2],[4,2]]");
        try {
            List<List<Integer>> nodes = _tcL(_tcL(0, -1), _tcL(1, 0), _tcL(2, 0), _tcL(3, 2), _tcL(4, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.isPreorder(nodes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nodes = [[0,-1],[1,0],[2,0],[3,1],[4,1]]");
        try {
            List<List<Integer>> nodes = _tcL(_tcL(0, -1), _tcL(1, 0), _tcL(2, 0), _tcL(3, 1), _tcL(4, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.isPreorder(nodes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}