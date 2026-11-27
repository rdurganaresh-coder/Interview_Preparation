package com.leetcode.arrays_hashing_greedy;

class Solution1444 {
    private int m;
    private int n;
    private int[][] s;
    private Integer[][][] f;
    private final int mod = (int) 1e9 + 7;

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        s = new int[m + 1][n + 1];
        f = new Integer[m][n][k];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int x = pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0;
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + x;
            }
        }
        return dfs(0, 0, k - 1);
    }

    private int dfs(int i, int j, int k) {
        if (k == 0) {
            return s[m][n] - s[i][n] - s[m][j] + s[i][j] > 0 ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int ans = 0;
        for (int x = i + 1; x < m; ++x) {
            if (s[x][n] - s[i][n] - s[x][j] + s[i][j] > 0) {
                ans = (ans + dfs(x, j, k - 1)) % mod;
            }
        }
        for (int y = j + 1; y < n; ++y) {
            if (s[m][y] - s[i][y] - s[m][j] + s[i][j] > 0) {
                ans = (ans + dfs(i, y, k - 1)) % mod;
            }
        }
        return f[i][j][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1444 _tcSol = new Solution1444();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pizza = [\"A..\",\"AAA\",\"...\"], k = 3");
        try {
            String[] pizza = new String[]{"A..", "AAA", "..."};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.ways(pizza, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pizza = [\"A..\",\"AA.\",\"...\"], k = 3");
        try {
            String[] pizza = new String[]{"A..", "AA.", "..."};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.ways(pizza, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "pizza = [\"A..\",\"A..\",\"...\"], k = 1");
        try {
            String[] pizza = new String[]{"A..", "A..", "..."};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.ways(pizza, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}