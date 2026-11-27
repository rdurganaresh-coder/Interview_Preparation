package com.leetcode.arrays_hashing_greedy;

class Solution1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                d[i][preferences[i][j]] = j;
            }
        }
        int[] p = new int[n];
        for (var e : pairs) {
            int x = e[0], y = e[1];
            p[x] = y;
            p[y] = x;
        }
        int ans = 0;
        for (int x = 0; x < n; ++x) {
            int y = p[x];
            for (int i = 0; i < d[x][y]; ++i) {
                int u = preferences[x][i];
                int v = p[u];
                if (d[u][x] < d[u][v]) {
                    ++ans;
                    break;
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
        Solution1583 _tcSol = new Solution1583();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]");
        try {
            int n = 4;
            int[][] preferences = new int[][]{new int[]{1, 2, 3}, new int[]{3, 2, 0}, new int[]{3, 1, 0}, new int[]{1, 2, 0}};
            int[][] pairs = new int[][]{new int[]{0, 1}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.unhappyFriends(n, preferences, pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, preferences = [[1], [0]], pairs = [[1, 0]]");
        try {
            int n = 2;
            int[][] preferences = new int[][]{new int[]{1}, new int[]{0}};
            int[][] pairs = new int[][]{new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.unhappyFriends(n, preferences, pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]");
        try {
            int n = 4;
            int[][] preferences = new int[][]{new int[]{1, 3, 2}, new int[]{2, 3, 0}, new int[]{1, 3, 0}, new int[]{0, 2, 1}};
            int[][] pairs = new int[][]{new int[]{1, 3}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.unhappyFriends(n, preferences, pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
