package com.leetcode.strings;

class Solution1974 {
    public int minTimeToType(String word) {
        int ans = word.length();
        char a = 'a';
        for (char c : word.toCharArray()) {
            int d = Math.abs(a - c);
            ans += Math.min(d, 26 - d);
            a = c;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1974 _tcSol = new Solution1974();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abc\"");
        try {
            String word = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToType(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"bza\"");
        try {
            String word = "bza";
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToType(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"zjpc\"");
        try {
            String word = "zjpc";
            System.out.println("  Output  : " + _tcShow(_tcSol.minTimeToType(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "34");
        System.out.println();
    }
}
