package com.leetcode.matrices_grids;

class Solution3189 {
    public int minMoves(int[][] rooks) {
        Arrays.sort(rooks, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int n = rooks.length;
        for (int i = 0; i < n; ++i) {
            ans += Math.abs(rooks[i][0] - i);
        }
        Arrays.sort(rooks, (a, b) -> a[1] - b[1]);
        for (int j = 0; j < n; ++j) {
            ans += Math.abs(rooks[j][1] - j);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3189 _tcSol = new Solution3189();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rooks = [[0,0],[1,0],[1,1]]");
        try {
            int[][] rooks = new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(rooks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rooks = [[0,0],[0,1],[0,2],[0,3]]");
        try {
            int[][] rooks = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(rooks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}