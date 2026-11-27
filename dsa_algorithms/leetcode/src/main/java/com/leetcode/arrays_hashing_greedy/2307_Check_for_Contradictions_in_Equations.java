package com.leetcode.arrays_hashing_greedy;

class Solution2307 {
    private int[] p;
    private double[] w;

    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        Map<String, Integer> d = new HashMap<>();
        int n = 0;
        for (var e : equations) {
            for (var s : e) {
                if (!d.containsKey(s)) {
                    d.put(s, n++);
                }
            }
        }
        p = new int[n];
        w = new double[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            w[i] = 1.0;
        }
        final double eps = 1e-5;
        for (int i = 0; i < equations.size(); ++i) {
            int a = d.get(equations.get(i).get(0)), b = d.get(equations.get(i).get(1));
            int pa = find(a), pb = find(b);
            double v = values[i];
            if (pa != pb) {
                p[pb] = pa;
                w[pb] = v * w[a] / w[b];
            } else if (Math.abs(v * w[a] - w[b]) >= eps) {
                return true;
            }
        }
        return false;
    }

    private int find(int x) {
        if (p[x] != x) {
            int root = find(p[x]);
            w[x] *= w[p[x]];
            p[x] = root;
        }
        return p[x];
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
        Solution2307 _tcSol = new Solution2307();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "equations = [[\"a\",\"b\"],[\"b\",\"c\"],[\"a\",\"c\"]], values = [3,0.5,1.5]");
        try {
            List<List<String>> equations = _tcL(_tcL("a", "b"), _tcL("b", "c"), _tcL("a", "c"));
            double[] values = new double[]{3.0, 0.5, 1.5};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkContradictions(equations, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "equations = [[\"le\",\"et\"],[\"le\",\"code\"],[\"code\",\"et\"]], values = [2,5,0.5]");
        try {
            List<List<String>> equations = _tcL(_tcL("le", "et"), _tcL("le", "code"), _tcL("code", "et"));
            double[] values = new double[]{2.0, 5.0, 0.5};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkContradictions(equations, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}