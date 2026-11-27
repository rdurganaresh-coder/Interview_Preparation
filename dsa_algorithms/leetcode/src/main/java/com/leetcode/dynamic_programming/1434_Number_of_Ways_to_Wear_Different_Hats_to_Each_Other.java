package com.leetcode.dynamic_programming;

class Solution1434 {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int m = 0;
        for (var h : hats) {
            for (int v : h) {
                m = Math.max(m, v);
            }
        }
        List<Integer>[] g = new List[m + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            for (int v : hats.get(i)) {
                g[v].add(i);
            }
        }
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[m + 1][1 << n];
        f[0][0] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < 1 << n; ++j) {
                f[i][j] = f[i - 1][j];
                for (int k : g[i]) {
                    if ((j >> k & 1) == 1) {
                        f[i][j] = (f[i][j] + f[i - 1][j ^ (1 << k)]) % mod;
                    }
                }
            }
        }
        return f[m][(1 << n) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution1434 _tcSol = new Solution1434();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hats = [[3,4],[4,5],[5]]");
        try {
            List<List<Integer>> hats = _tcL(_tcL(3, 4), _tcL(4, 5), _tcL(5));
            System.out.println("  Output  : " + _tcShow(_tcSol.numberWays(hats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hats = [[3,5,1],[3,5]]");
        try {
            List<List<Integer>> hats = _tcL(_tcL(3, 5, 1), _tcL(3, 5));
            System.out.println("  Output  : " + _tcShow(_tcSol.numberWays(hats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]");
        try {
            List<List<Integer>> hats = _tcL(_tcL(1, 2, 3, 4), _tcL(1, 2, 3, 4), _tcL(1, 2, 3, 4), _tcL(1, 2, 3, 4));
            System.out.println("  Output  : " + _tcShow(_tcSol.numberWays(hats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();
    }
}