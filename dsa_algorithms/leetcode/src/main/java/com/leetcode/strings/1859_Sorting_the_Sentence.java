package com.leetcode.strings;

class Solution1859 {
    public String sortSentence(String s) {
        String[] ws = s.split(" ");
        int n = ws.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            String w = ws[i];
            ans[w.charAt(w.length() - 1) - '1'] = w.substring(0, w.length() - 1);
        }
        return String.join(" ", ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1859 _tcSol = new Solution1859();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"is2 sentence4 This1 a3\"");
        try {
            String s = "is2 sentence4 This1 a3";
            System.out.println("  Output  : " + _tcShow(_tcSol.sortSentence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"This is a sentence\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"Myself2 Me1 I4 and3\"");
        try {
            String s = "Myself2 Me1 I4 and3";
            System.out.println("  Output  : " + _tcShow(_tcSol.sortSentence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Me Myself and I\"");
        System.out.println();
    }
}