package com.leetcode.strings;

class Solution0524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String t : dictionary) {
            int a = ans.length(), b = t.length();
            if (check(t, s) && (a < b || (a == b && t.compareTo(ans) < 0))) {
                ans = t;
            }
        }
        return ans;
    }

    private boolean check(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0;
        for (int j = 0; i < m && j < n; ++j) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
        }
        return i == m;
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
        Solution0524 _tcSol = new Solution0524();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abpcplea\", dictionary = [\"ale\",\"apple\",\"monkey\",\"plea\"]");
        try {
            String s = "abpcplea";
            List<String> dictionary = _tcL("ale", "apple", "monkey", "plea");
            System.out.println("  Output  : " + _tcShow(_tcSol.findLongestWord(s, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"apple\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abpcplea\", dictionary = [\"a\",\"b\",\"c\"]");
        try {
            String s = "abpcplea";
            List<String> dictionary = _tcL("a", "b", "c");
            System.out.println("  Output  : " + _tcShow(_tcSol.findLongestWord(s, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();
    }
}