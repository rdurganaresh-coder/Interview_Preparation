package com.leetcode.sql_database;

class Solution2933 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> d = new HashMap<>();
        for (var e : access_times) {
            String name = e.get(0), s = e.get(1);
            int t = Integer.valueOf(s.substring(0, 2)) * 60 + Integer.valueOf(s.substring(2));
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        }
        List<String> ans = new ArrayList<>();
        for (var e : d.entrySet()) {
            String name = e.getKey();
            var ts = e.getValue();
            Collections.sort(ts);
            for (int i = 2; i < ts.size(); ++i) {
                if (ts.get(i) - ts.get(i - 2) < 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        return ans;
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
        Solution2933 _tcSol = new Solution2933();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "access_times = [[\"a\",\"0549\"],[\"b\",\"0457\"],[\"a\",\"0532\"],[\"a\",\"0621\"],[\"b\",\"0540\"]]");
        try {
            List<List<String>> access_times = _tcL(_tcL("a", "0549"), _tcL("b", "0457"), _tcL("a", "0532"), _tcL("a", "0621"), _tcL("b", "0540"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findHighAccessEmployees(access_times)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "access_times = [[\"d\",\"0002\"],[\"c\",\"0808\"],[\"c\",\"0829\"],[\"e\",\"0215\"],[\"d\",\"1508\"],[\"d\",\"1444\"],[\"d\",\"1410\"],[\"c\",\"0809\"]]");
        try {
            List<List<String>> access_times = _tcL(_tcL("d", "0002"), _tcL("c", "0808"), _tcL("c", "0829"), _tcL("e", "0215"), _tcL("d", "1508"), _tcL("d", "1444"), _tcL("d", "1410"), _tcL("c", "0809"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findHighAccessEmployees(access_times)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"c\",\"d\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "access_times = [[\"cd\",\"1025\"],[\"ab\",\"1025\"],[\"cd\",\"1046\"],[\"cd\",\"1055\"],[\"ab\",\"1124\"],[\"ab\",\"1120\"]]");
        try {
            List<List<String>> access_times = _tcL(_tcL("cd", "1025"), _tcL("ab", "1025"), _tcL("cd", "1046"), _tcL("cd", "1055"), _tcL("ab", "1124"), _tcL("ab", "1120"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findHighAccessEmployees(access_times)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"ab\",\"cd\"]");
        System.out.println();
    }
}