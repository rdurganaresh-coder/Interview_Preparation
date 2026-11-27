package com.leetcode.arrays_hashing_greedy;

class Solution0547 {
    private int[][] g;
    private boolean[] vis;

    public int findCircleNum(int[][] isConnected) {
        g = isConnected;
        int n = g.length;
        vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                dfs(i);
                ++ans;
            }
        }
        return ans;
    }

    private void dfs(int i) {
        vis[i] = true;
        for (int j = 0; j < g.length; ++j) {
            if (!vis[j] && g[i][j] == 1) {
                dfs(j);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0547 _tcSol = new Solution0547();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "isConnected = [[1,1,0],[1,1,0],[0,0,1]]");
        try {
            int[][] isConnected = new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCircleNum(isConnected)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "isConnected = [[1,0,0],[0,1,0],[0,0,1]]");
        try {
            int[][] isConnected = new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCircleNum(isConnected)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}