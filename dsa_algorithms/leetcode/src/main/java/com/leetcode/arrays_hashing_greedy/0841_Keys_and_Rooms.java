package com.leetcode.arrays_hashing_greedy;

class Solution0841 {
    private int cnt;
    private boolean[] vis;
    private List<List<Integer>> g;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        g = rooms;
        vis = new boolean[g.size()];
        dfs(0);
        return cnt == g.size();
    }

    private void dfs(int i) {
        if (vis[i]) {
            return;
        }
        vis[i] = true;
        ++cnt;
        for (int j : g.get(i)) {
            dfs(j);
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
        Solution0841 _tcSol = new Solution0841();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rooms = [[1],[2],[3],[]]");
        try {
            List<List<Integer>> rooms = _tcL(_tcL(1), _tcL(2), _tcL(3), _tcL());
            System.out.println("  Output  : " + _tcShow(_tcSol.canVisitAllRooms(rooms)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rooms = [[1,3],[3,0,1],[2],[0]]");
        try {
            List<List<Integer>> rooms = _tcL(_tcL(1, 3), _tcL(3, 0, 1), _tcL(2), _tcL(0));
            System.out.println("  Output  : " + _tcShow(_tcSol.canVisitAllRooms(rooms)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
