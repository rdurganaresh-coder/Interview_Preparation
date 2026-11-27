package com.leetcode.strings;

class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String w : words) {
            if (w.startsWith(pref)) {
                ++ans;
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
        Solution2185 _tcSol = new Solution2185();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"pay\",\"attention\",\"practice\",\"attend\"], pref = \"at\"");
        try {
            String[] words = new String[]{"pay", "attention", "practice", "attend"};
            String pref = "at";
            System.out.println("  Output  : " + _tcShow(_tcSol.prefixCount(words, pref)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"leetcode\",\"win\",\"loops\",\"success\"], pref = \"code\"");
        try {
            String[] words = new String[]{"leetcode", "win", "loops", "success"};
            String pref = "code";
            System.out.println("  Output  : " + _tcShow(_tcSol.prefixCount(words, pref)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}