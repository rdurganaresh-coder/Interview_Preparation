package com.leetcode.bit_manipulation_math;

class Solution0473 {
    public boolean makesquare(int[] matchsticks) {
        int s = 0, mx = 0;
        for (int v : matchsticks) {
            s += v;
            mx = Math.max(mx, v);
        }
        int x = s / 4, mod = s % 4;
        if (mod != 0 || x < mx) {
            return false;
        }
        Arrays.sort(matchsticks);
        int[] edges = new int[4];
        return dfs(matchsticks.length - 1, x, matchsticks, edges);
    }

    private boolean dfs(int u, int x, int[] matchsticks, int[] edges) {
        if (u < 0) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            if (i > 0 && edges[i - 1] == edges[i]) {
                continue;
            }
            edges[i] += matchsticks[u];
            if (edges[i] <= x && dfs(u - 1, x, matchsticks, edges)) {
                return true;
            }
            edges[i] -= matchsticks[u];
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0473 _tcSol = new Solution0473();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matchsticks = [1,1,2,2,2]");
        try {
            int[] matchsticks = new int[]{1, 1, 2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.makesquare(matchsticks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matchsticks = [3,3,3,3,4]");
        try {
            int[] matchsticks = new int[]{3, 3, 3, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.makesquare(matchsticks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}