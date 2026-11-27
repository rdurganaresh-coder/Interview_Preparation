package com.leetcode.strings;

class Solution0520 {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ++cnt;
            }
        }
        return cnt == 0 || cnt == word.length()
            || (cnt == 1 && Character.isUpperCase(word.charAt(0)));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0520 _tcSol = new Solution0520();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"USA\"");
        try {
            String word = "USA";
            System.out.println("  Output  : " + _tcShow(_tcSol.detectCapitalUse(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"FlaG\"");
        try {
            String word = "FlaG";
            System.out.println("  Output  : " + _tcShow(_tcSol.detectCapitalUse(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}