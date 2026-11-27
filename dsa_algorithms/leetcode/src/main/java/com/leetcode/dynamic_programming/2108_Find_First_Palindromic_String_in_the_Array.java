package com.leetcode.dynamic_programming;

class Solution2108 {
    public String firstPalindrome(String[] words) {
        for (var w : words) {
            boolean ok = true;
            for (int i = 0, j = w.length() - 1; i < j && ok; ++i, --j) {
                if (w.charAt(i) != w.charAt(j)) {
                    ok = false;
                }
            }
            if (ok) {
                return w;
            }
        }
        return "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2108 _tcSol = new Solution2108();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abc\",\"car\",\"ada\",\"racecar\",\"cool\"]");
        try {
            String[] words = new String[]{"abc", "car", "ada", "racecar", "cool"};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstPalindrome(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ada\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"notapalindrome\",\"racecar\"]");
        try {
            String[] words = new String[]{"notapalindrome", "racecar"};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstPalindrome(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"racecar\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"def\",\"ghi\"]");
        try {
            String[] words = new String[]{"def", "ghi"};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstPalindrome(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}