package com.leetcode.arrays_hashing_greedy;

class Solution3238 {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] cnt = new int[n][11];
        Set<Integer> s = new HashSet<>();
        for (var p : pick) {
            int x = p[0], y = p[1];
            if (++cnt[x][y] > x) {
                s.add(x);
            }
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3238 _tcSol = new Solution3238();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, pick = [[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]");
        try {
            int n = 4;
            int[][] pick = new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 0}, new int[]{2, 1}, new int[]{2, 1}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.winningPlayerCount(n, pick)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, pick = [[1,1],[1,2],[1,3],[1,4]]");
        try {
            int n = 5;
            int[][] pick = new int[][]{new int[]{1, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.winningPlayerCount(n, pick)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, pick = [[1,1],[2,4],[2,4],[2,4]]");
        try {
            int n = 5;
            int[][] pick = new int[][]{new int[]{1, 1}, new int[]{2, 4}, new int[]{2, 4}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.winningPlayerCount(n, pick)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
