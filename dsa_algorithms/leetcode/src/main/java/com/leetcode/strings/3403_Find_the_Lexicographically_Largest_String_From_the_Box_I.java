package com.leetcode.strings;

class Solution3403 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String ans = "";
        for (int i = 0; i < n; ++i) {
            String t = word.substring(i, Math.min(n, i + n - (numFriends - 1)));
            if (ans.compareTo(t) < 0) {
                ans = t;
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
        Solution3403 _tcSol = new Solution3403();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"dbca\", numFriends = 2");
        try {
            String word = "dbca";
            int numFriends = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.answerString(word, numFriends)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dbc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"gggg\", numFriends = 4");
        try {
            String word = "gggg";
            int numFriends = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.answerString(word, numFriends)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"g\"");
        System.out.println();
    }
}