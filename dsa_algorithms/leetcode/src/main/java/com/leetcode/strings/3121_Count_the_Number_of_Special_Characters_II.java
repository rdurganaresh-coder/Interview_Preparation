package com.leetcode.strings;

class Solution3121 {
    public int numberOfSpecialChars(String word) {
        int[] first = new int['z' + 1];
        int[] last = new int['z' + 1];
        for (int i = 1; i <= word.length(); ++i) {
            int j = word.charAt(i - 1);
            if (first[j] == 0) {
                first[j] = i;
            }
            last[j] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            int a = 'a' + i;
            int b = 'A' + i;
            if (last[a] > 0 && last[a] < first[b]) {
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
        Solution3121 _tcSol = new Solution3121();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aaAbcBC\"");
        try {
            String word = "aaAbcBC";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSpecialChars(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abc\"");
        try {
            String word = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSpecialChars(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"AbBCab\"");
        try {
            String word = "AbBCab";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSpecialChars(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
