package com.leetcode.dynamic_programming;

class Solution1595_2 {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size(), n = cost.get(0).size();
        final int inf = 1 << 30;
        int[] f = new int[1 << n];
        Arrays.fill(f, inf);
        f[0] = 0;
        int[] g = f.clone();
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < 1 << n; ++j) {
                g[j] = inf;
                for (int k = 0; k < n; ++k) {
                    if ((j >> k & 1) == 1) {
                        int c = cost.get(i - 1).get(k);
                        g[j] = Math.min(g[j], g[j ^ (1 << k)] + c);
                        g[j] = Math.min(g[j], f[j] + c);
                        g[j] = Math.min(g[j], f[j ^ (1 << k)] + c);
                    }
                }
            }
            System.arraycopy(g, 0, f, 0, 1 << n);
        }
        return f[(1 << n) - 1];
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
        Solution1595_2 _tcSol = new Solution1595_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cost = [[15, 96], [36, 2]]");
        try {
            List<List<Integer>> cost = _tcL(_tcL(15, 96), _tcL(36, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.connectTwoGroups(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]");
        try {
            List<List<Integer>> cost = _tcL(_tcL(1, 3, 5), _tcL(4, 1, 1), _tcL(1, 5, 3));
            System.out.println("  Output  : " + _tcShow(_tcSol.connectTwoGroups(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]");
        try {
            List<List<Integer>> cost = _tcL(_tcL(2, 5, 1), _tcL(3, 4, 7), _tcL(8, 1, 2), _tcL(6, 2, 4), _tcL(3, 8, 8));
            System.out.println("  Output  : " + _tcShow(_tcSol.connectTwoGroups(cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}