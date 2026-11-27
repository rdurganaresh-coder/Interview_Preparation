package com.leetcode.graphs_shortest_path;

class Solution1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] d = new int[n + 1];
        for (var e : relations) {
            d[e[1]] |= 1 << e[0];
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        while (!q.isEmpty()) {
            var p = q.pollFirst();
            int cur = p[0], t = p[1];
            if (cur == (1 << (n + 1)) - 2) {
                return t;
            }
            int nxt = 0;
            for (int i = 1; i <= n; ++i) {
                if ((cur & d[i]) == d[i]) {
                    nxt |= 1 << i;
                }
            }
            nxt ^= cur;
            if (Integer.bitCount(nxt) <= k) {
                if (vis.add(nxt | cur)) {
                    q.offer(new int[] {nxt | cur, t + 1});
                }
            } else {
                int x = nxt;
                while (nxt > 0) {
                    if (Integer.bitCount(nxt) == k && vis.add(nxt | cur)) {
                        q.offer(new int[] {nxt | cur, t + 1});
                    }
                    nxt = (nxt - 1) & x;
                }
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1494 _tcSol = new Solution1494();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, relations = [[2,1],[3,1],[1,4]], k = 2");
        try {
            int n = 4;
            int[][] relations = new int[][]{new int[]{2, 1}, new int[]{3, 1}, new int[]{1, 4}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfSemesters(n, relations, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2");
        try {
            int n = 5;
            int[][] relations = new int[][]{new int[]{2, 1}, new int[]{3, 1}, new int[]{4, 1}, new int[]{1, 5}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfSemesters(n, relations, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}