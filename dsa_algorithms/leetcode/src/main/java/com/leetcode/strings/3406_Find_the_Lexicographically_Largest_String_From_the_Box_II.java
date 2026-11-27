package com.leetcode.strings;

class Solution3406 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String s = lastSubstring(word);
        return s.substring(0, Math.min(s.length(), word.length() - numFriends + 1));
    }

    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;
        while (j + k < n) {
            int d = s.charAt(i + k) - s.charAt(j + k);
            if (d == 0) {
                ++k;
            } else if (d < 0) {
                i += k + 1;
                k = 0;
                if (i >= j) {
                    j = i + 1;
                }
            } else {
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3406 _tcSol = new Solution3406();
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