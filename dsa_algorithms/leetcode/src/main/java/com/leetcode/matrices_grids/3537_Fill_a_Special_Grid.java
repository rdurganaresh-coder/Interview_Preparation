package com.leetcode.matrices_grids;

class Solution3537 {
    private int[][] ans;
    private int val;

    public int[][] specialGrid(int n) {
        int m = 1 << n;
        ans = new int[m][m];
        dfs(0, m - 1, m);
        return ans;
    }

    private void dfs(int x, int y, int k) {
        if (k == 1) {
            ans[x][y] = val++;
            return;
        }

        int h = k / 2;
        dfs(x, y, h);
        dfs(x + h, y, h);
        dfs(x + h, y - h, h);
        dfs(x, y - h, h);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3537 _tcSol = new Solution3537();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 0");
        try {
            int n = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.specialGrid(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.specialGrid(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,0],[2,1]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.specialGrid(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[15,12,3,0],[14,13,2,1],[11,8,7,4],[10,9,6,5]]");
        System.out.println();
    }
}