package com.leetcode.strings;

class Solution2114 {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for (var s : sentences) {
            int cnt = 1;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == ' ') {
                    ++cnt;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2114 _tcSol = new Solution2114();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentences = [\"alice and bob love leetcode\", \"i think so too\", \"this is great thanks very much\"]");
        try {
            String[] sentences = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostWordsFound(sentences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentences = [\"please wait\", \"continue to fight\", \"continue to win\"]");
        try {
            String[] sentences = new String[]{"please wait", "continue to fight", "continue to win"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostWordsFound(sentences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}