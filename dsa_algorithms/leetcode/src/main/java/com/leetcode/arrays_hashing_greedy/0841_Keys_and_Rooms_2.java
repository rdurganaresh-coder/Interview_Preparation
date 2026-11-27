package com.leetcode.arrays_hashing_greedy;

class Solution0841_2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            ++cnt;
            for (int j : rooms.get(i)) {
                q.offer(j);
            }
        }
        return cnt == n;
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
        Solution0841_2 _tcSol = new Solution0841_2();
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
