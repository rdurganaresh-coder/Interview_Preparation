package com.leetcode.strings;

class Solution2957 {
    public int removeAlmostEqualCharacters(String word) {
        int ans = 0, n = word.length();
        for (int i = 1; i < n; ++i) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) < 2) {
                ++ans;
                ++i;
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
        Solution2957 _tcSol = new Solution2957();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aaaaa\"");
        try {
            String word = "aaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeAlmostEqualCharacters(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abddez\"");
        try {
            String word = "abddez";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeAlmostEqualCharacters(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"zyxyxyz\"");
        try {
            String word = "zyxyxyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeAlmostEqualCharacters(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}