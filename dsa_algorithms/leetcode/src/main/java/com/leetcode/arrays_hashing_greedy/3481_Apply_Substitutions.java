package com.leetcode.arrays_hashing_greedy;

class Solution3481 {
    private final Map<String, String> d = new HashMap<>();

    public String applySubstitutions(List<List<String>> replacements, String text) {
        for (List<String> e : replacements) {
            d.put(e.get(0), e.get(1));
        }
        return dfs(text);
    }

    private String dfs(String s) {
        int i = s.indexOf("%");
        if (i == -1) {
            return s;
        }
        int j = s.indexOf("%", i + 1);
        if (j == -1) {
            return s;
        }
        String key = s.substring(i + 1, j);
        String replacement = dfs(d.getOrDefault(key, ""));
        return s.substring(0, i) + replacement + dfs(s.substring(j + 1));
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
        Solution3481 _tcSol = new Solution3481();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "replacements = [[\"A\",\"abc\"],[\"B\",\"def\"]], text = \"%A%_%B%\"");
        try {
            List<List<String>> replacements = _tcL(_tcL("A", "abc"), _tcL("B", "def"));
            String text = "%A%_%B%";
            System.out.println("  Output  : " + _tcShow(_tcSol.applySubstitutions(replacements, text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc_def\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "replacements = [[\"A\",\"bce\"],[\"B\",\"ace\"],[\"C\",\"abc%B%\"]], text = \"%A%_%B%_%C%\"");
        try {
            List<List<String>> replacements = _tcL(_tcL("A", "bce"), _tcL("B", "ace"), _tcL("C", "abc%B%"));
            String text = "%A%_%B%_%C%";
            System.out.println("  Output  : " + _tcShow(_tcSol.applySubstitutions(replacements, text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bce_ace_abcace\"");
        System.out.println();
    }
}
