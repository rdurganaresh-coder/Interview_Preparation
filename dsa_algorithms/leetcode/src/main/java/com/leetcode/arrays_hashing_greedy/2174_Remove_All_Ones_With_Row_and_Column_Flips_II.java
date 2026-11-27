package com.leetcode.arrays_hashing_greedy;

class Solution2174 {
    public int removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int state = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    state |= 1 << (i * n + j);
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(state);
        Set<Integer> vis = new HashSet<>();
        vis.add(state);
        int ans = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                state = q.poll();
                if (state == 0) {
                    return ans;
                }
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] == 0) {
                            continue;
                        }
                        int nxt = state;
                        for (int r = 0; r < m; ++r) {
                            nxt &= ~(1 << (r * n + j));
                        }
                        for (int c = 0; c < n; ++c) {
                            nxt &= ~(1 << (i * n + c));
                        }
                        if (!vis.contains(nxt)) {
                            vis.add(nxt);
                            q.offer(nxt);
                        }
                    }
                }
            }
            ++ans;
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2174 _tcSol = new Solution2174();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,1],[1,1,1],[0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOnes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,0],[1,0,1],[0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOnes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0,0],[0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOnes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}