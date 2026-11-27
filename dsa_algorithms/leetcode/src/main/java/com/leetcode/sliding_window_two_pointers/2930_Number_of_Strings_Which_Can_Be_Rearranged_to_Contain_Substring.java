package com.leetcode.sliding_window_two_pointers;

class Solution2930 {
    private final int mod = (int) 1e9 + 7;
    private Long[][][][] f;

    public int stringCount(int n) {
        f = new Long[n + 1][2][3][2];
        return (int) dfs(n, 0, 0, 0);
    }

    private long dfs(int i, int l, int e, int t) {
        if (i == 0) {
            return l == 1 && e == 2 && t == 1 ? 1 : 0;
        }
        if (f[i][l][e][t] != null) {
            return f[i][l][e][t];
        }
        long a = dfs(i - 1, l, e, t) * 23 % mod;
        long b = dfs(i - 1, Math.min(1, l + 1), e, t);
        long c = dfs(i - 1, l, Math.min(2, e + 1), t);
        long d = dfs(i - 1, l, e, Math.min(1, t + 1));
        return f[i][l][e][t] = (a + b + c + d) % mod;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2930 _tcSol = new Solution2930();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "83943898");
        System.out.println();
    }
}
