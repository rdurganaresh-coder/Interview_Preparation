package com.leetcode.graphs_shortest_path;

class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> s = new HashSet<>();
        for (var p : paths) {
            s.add(p.get(0));
        }
        for (int i = 0;; ++i) {
            var b = paths.get(i).get(1);
            if (!s.contains(b)) {
                return b;
            }
        }
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
        Solution1436 _tcSol = new Solution1436();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "paths = [[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]");
        try {
            List<List<String>> paths = _tcL(_tcL("London", "New York"), _tcL("New York", "Lima"), _tcL("Lima", "Sao Paulo"));
            System.out.println("  Output  : " + _tcShow(_tcSol.destCity(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Sao Paulo\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "paths = [[\"B\",\"C\"],[\"D\",\"B\"],[\"C\",\"A\"]]");
        try {
            List<List<String>> paths = _tcL(_tcL("B", "C"), _tcL("D", "B"), _tcL("C", "A"));
            System.out.println("  Output  : " + _tcShow(_tcSol.destCity(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"A\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "paths = [[\"A\",\"Z\"]]");
        try {
            List<List<String>> paths = _tcL(_tcL("A", "Z"));
            System.out.println("  Output  : " + _tcShow(_tcSol.destCity(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Z\"");
        System.out.println();
    }
}
