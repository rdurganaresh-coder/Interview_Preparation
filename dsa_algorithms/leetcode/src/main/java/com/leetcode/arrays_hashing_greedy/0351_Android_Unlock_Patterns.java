package com.leetcode.arrays_hashing_greedy;

class Solution0351 {
    private int m;
    private int n;
    private int[][] cross = new int[10][10];
    private boolean[] vis = new boolean[10];

    public int numberOfPatterns(int m, int n) {
        this.m = m;
        this.n = n;
        cross[1][3] = cross[3][1] = 2;
        cross[1][7] = cross[7][1] = 4;
        cross[1][9] = cross[9][1] = 5;
        cross[2][8] = cross[8][2] = 5;
        cross[3][7] = cross[7][3] = 5;
        cross[3][9] = cross[9][3] = 6;
        cross[4][6] = cross[6][4] = 5;
        cross[7][9] = cross[9][7] = 8;
        return dfs(1, 1) * 4 + dfs(2, 1) * 4 + dfs(5, 1);
    }

    private int dfs(int i, int cnt) {
        if (cnt > n) {
            return 0;
        }
        vis[i] = true;
        int ans = cnt >= m ? 1 : 0;
        for (int j = 1; j < 10; ++j) {
            int x = cross[i][j];
            if (!vis[j] && (x == 0 || vis[x])) {
                ans += dfs(j, cnt + 1);
            }
        }
        vis[i] = false;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0351 _tcSol = new Solution0351();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 1, n = 1");
        try {
            int m = 1;
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPatterns(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 1, n = 2");
        try {
            int m = 1;
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPatterns(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "65");
        System.out.println();
    }
}