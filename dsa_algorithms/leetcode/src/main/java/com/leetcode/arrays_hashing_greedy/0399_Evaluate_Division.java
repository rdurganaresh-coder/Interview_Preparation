package com.leetcode.arrays_hashing_greedy;

class Solution0399 {
    private Map<String, String> p;
    private Map<String, Double> w;

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        p = new HashMap<>();
        w = new HashMap<>();
        for (List<String> e : equations) {
            p.put(e.get(0), e.get(0));
            p.put(e.get(1), e.get(1));
            w.put(e.get(0), 1.0);
            w.put(e.get(1), 1.0);
        }
        for (int i = 0; i < n; ++i) {
            List<String> e = equations.get(i);
            String a = e.get(0), b = e.get(1);
            String pa = find(a), pb = find(b);
            if (Objects.equals(pa, pb)) {
                continue;
            }
            p.put(pa, pb);
            w.put(pa, w.get(b) * values[i] / w.get(a));
        }
        int m = queries.size();
        double[] ans = new double[m];
        for (int i = 0; i < m; ++i) {
            String c = queries.get(i).get(0), d = queries.get(i).get(1);
            ans[i] = !p.containsKey(c) || !p.containsKey(d) || !Objects.equals(find(c), find(d))
                ? -1.0
                : w.get(c) / w.get(d);
        }
        return ans;
    }

    private String find(String x) {
        if (!Objects.equals(p.get(x), x)) {
            String origin = p.get(x);
            p.put(x, find(p.get(x)));
            w.put(x, w.get(x) * w.get(origin));
        }
        return p.get(x);
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
        Solution0399 _tcSol = new Solution0399();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "equations = [[\"a\",\"b\"],[\"b\",\"c\"]], values = [2.0,3.0], queries = [[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]");
        try {
            List<List<String>> equations = _tcL(_tcL("a", "b"), _tcL("b", "c"));
            double[] values = new double[]{2.0, 3.0};
            List<List<String>> queries = _tcL(_tcL("a", "c"), _tcL("b", "a"), _tcL("a", "e"), _tcL("a", "a"), _tcL("x", "x"));
            System.out.println("  Output  : " + _tcShow(_tcSol.calcEquation(equations, values, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6.00000,0.50000,-1.00000,1.00000,-1.00000]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "equations = [[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]], values = [1.5,2.5,5.0], queries = [[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]");
        try {
            List<List<String>> equations = _tcL(_tcL("a", "b"), _tcL("b", "c"), _tcL("bc", "cd"));
            double[] values = new double[]{1.5, 2.5, 5.0};
            List<List<String>> queries = _tcL(_tcL("a", "c"), _tcL("c", "b"), _tcL("bc", "cd"), _tcL("cd", "bc"));
            System.out.println("  Output  : " + _tcShow(_tcSol.calcEquation(equations, values, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3.75000,0.40000,5.00000,0.20000]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "equations = [[\"a\",\"b\"]], values = [0.5], queries = [[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]");
        try {
            List<List<String>> equations = _tcL(_tcL("a", "b"));
            double[] values = new double[]{0.5};
            List<List<String>> queries = _tcL(_tcL("a", "b"), _tcL("b", "a"), _tcL("a", "c"), _tcL("x", "y"));
            System.out.println("  Output  : " + _tcShow(_tcSol.calcEquation(equations, values, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0.50000,2.00000,-1.00000,-1.00000]");
        System.out.println();
    }
}