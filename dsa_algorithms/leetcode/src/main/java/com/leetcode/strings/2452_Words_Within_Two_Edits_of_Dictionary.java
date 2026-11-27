package com.leetcode.strings;

class Solution2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int n = queries[0].length();
        for (var s : queries) {
            for (var t : dictionary) {
                int cnt = 0;
                for (int i = 0; i < n; ++i) {
                    if (s.charAt(i) != t.charAt(i)) {
                        ++cnt;
                    }
                }
                if (cnt < 3) {
                    ans.add(s);
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

    public static void main(String[] args) {
        Solution2452 _tcSol = new Solution2452();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [\"word\",\"note\",\"ants\",\"wood\"], dictionary = [\"wood\",\"joke\",\"moat\"]");
        try {
            String[] queries = new String[]{"word", "note", "ants", "wood"};
            String[] dictionary = new String[]{"wood", "joke", "moat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoEditWords(queries, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"word\",\"note\",\"wood\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [\"yes\"], dictionary = [\"not\"]");
        try {
            String[] queries = new String[]{"yes"};
            String[] dictionary = new String[]{"not"};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoEditWords(queries, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}