package com.leetcode.strings;

class Solution2278 {
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                ++cnt;
            }
        }
        return cnt * 100 / s.length();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2278 _tcSol = new Solution2278();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"foobar\", letter = \"o\"");
        try {
            String s = "foobar";
            char letter = 'o';
            System.out.println("  Output  : " + _tcShow(_tcSol.percentageLetter(s, letter)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "33");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"jjjj\", letter = \"k\"");
        try {
            String s = "jjjj";
            char letter = 'k';
            System.out.println("  Output  : " + _tcShow(_tcSol.percentageLetter(s, letter)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}