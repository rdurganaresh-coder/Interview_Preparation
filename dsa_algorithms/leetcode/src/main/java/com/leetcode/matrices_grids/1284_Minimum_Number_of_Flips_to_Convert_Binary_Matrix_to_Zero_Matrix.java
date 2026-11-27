package com.leetcode.matrices_grids;

class Solution1284 {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int state = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) {
                    state |= 1 << (i * n + j);
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(state);
        Set<Integer> vis = new HashSet<>();
        vis.add(state);
        int ans = 0;
        int[] dirs = {0, -1, 0, 1, 0, 0};
        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; --t) {
                state = q.poll();
                if (state == 0) {
                    return ans;
                }
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        int nxt = state;
                        for (int k = 0; k < 5; ++k) {
                            int x = i + dirs[k], y = j + dirs[k + 1];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                continue;
                            }
                            if ((nxt & (1 << (x * n + y))) != 0) {
                                nxt -= 1 << (x * n + y);
                            } else {
                                nxt |= 1 << (x * n + y);
                            }
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
        Solution1284 _tcSol = new Solution1284();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[0,0],[0,1]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[0]]");
        try {
            int[][] mat = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[1,0,0],[1,0,0]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 0, 0}, new int[]{1, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}