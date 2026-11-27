package com.leetcode.strings;

class Solution0249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> g = new HashMap<>();
        for (var s : strings) {
            char[] t = s.toCharArray();
            int diff = t[0] - 'a';
            for (int i = 0; i < t.length; ++i) {
                t[i] = (char) (t[i] - diff);
                if (t[i] < 'a') {
                    t[i] += 26;
                }
            }
            g.computeIfAbsent(new String(t), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(g.values());
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0249 _tcSol = new Solution0249();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strings = [\"abc\",\"bcd\",\"acef\",\"xyz\",\"az\",\"ba\",\"a\",\"z\"]");
        try {
            String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupStrings(strings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"acef\"],[\"a\",\"z\"],[\"abc\",\"bcd\",\"xyz\"],[\"az\",\"ba\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strings = [\"a\"]");
        try {
            String[] strings = new String[]{"a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupStrings(strings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"a\"]]");
        System.out.println();
    }
}